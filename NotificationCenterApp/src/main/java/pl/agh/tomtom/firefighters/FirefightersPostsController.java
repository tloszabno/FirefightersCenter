package pl.agh.tomtom.firefighters;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;

@Controller
public class FirefightersPostsController {

	private static final Logger log = LogManager.getLogger();

	@RequestMapping(method = RequestMethod.GET, value = "allFirefightersPosts.htm")
	public ModelAndView allFirefightersPosts() {
		log.entry();

		ModelAndView mav = FirefightersViewHelper
				.createMAV("viewFirefightersPosts");
		log.exit(mav);
		return mav;
	}

	@RequestMapping(value = "getAllFirefightersPosts", method = RequestMethod.GET)
	@ResponseBody
	public List<FirefightersPostDTO> getAllFirefightersPosts() {
		log.entry();

		List<FirefightersPostDTO> posts = getSampleData();
		log.exit(posts);
		return posts;
	}

	@RequestMapping(value = "saveFirefightersPosts", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String saveFirefightersPosts(
			@RequestBody List<FirefightersPostDTO> posts) {
		log.entry(posts);

		log.warn("Zapisano " + posts);
		System.out.println("Zapisano" + posts);

		log.exit();
		return "OK";
	}

	private List<FirefightersPostDTO> getSampleData() {
		FirefightersPostDTO post = new FirefightersPostDTO();
		post.setAddress("Rynek");
		post.setCity("Zabno");
		post.setCommunity("Zabno");
		post.setName("OPS w Zabnie");
		post.setSystemIpAddress("192.168.32.1");
		post.setId(1L);
		return Collections.singletonList(post);
	}
}
