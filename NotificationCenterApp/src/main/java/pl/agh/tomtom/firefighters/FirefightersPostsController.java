package pl.agh.tomtom.firefighters;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.services.FirefightersPostService;

@Controller
public class FirefightersPostsController {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("firefightersPostService")
	private FirefightersPostService firefightersPostService;

	@RequestMapping(method = RequestMethod.GET, value = "allFirefightersPosts.htm")
	public ModelAndView allFirefightersPosts() {
		log.entry();

		ModelAndView mav = FirefightersViewHelper.createMAV("viewFirefightersPosts");

		log.exit(mav);
		return mav;
	}

	@RequestMapping(value = "getAllFirefightersPosts", method = RequestMethod.GET)
	@ResponseBody
	public List<FirefightersPostDTO> getAllFirefightersPosts() {
		log.entry();

		List<FirefightersPostDTO> posts = firefightersPostService.getAllFirefightersPosts();
		posts = posts.stream().sorted((el1, el2) -> Long.valueOf(el1.getId() - el2.getId()).intValue())
				.collect(Collectors.toList());

		log.exit(posts);
		return posts;
	}

	@RequestMapping(value = "saveFirefightersPosts", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String saveFirefightersPosts(@RequestBody List<FirefightersPostDTO> posts) throws FireException {
		log.entry(posts);

		for (FirefightersPostDTO postDTO : posts) {
			firefightersPostService.saveFirefightersPost(postDTO);
		}

		log.exit();
		return "OK";
	}

	@RequestMapping(value = "getFirefightersPostDetails", method = RequestMethod.GET)
	public ModelAndView getFirefightersPostDetails(Long id) throws FireException {
		log.entry();

		ModelAndView mav = new ModelAndView("firefightersPostDetails");
		FirefightersPostCurrentDetailsDTO firefightersPostDTO = firefightersPostService.getCurrentDetails(id);
		mav.addObject("post", firefightersPostDTO);

		log.exit(mav);
		return mav;
	}
}
