package pl.agh.tomtom.firefighters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dao.ZgloszenieDAO;

@Controller
public class WelcomeController {

	private static final Logger log = LogManager
			.getLogger(WelcomeController.class);

	@Autowired
	@Qualifier("zgloszenieDAO")
	@Required
	private ZgloszenieDAO zgloszenieDAO;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView welcome(@RequestParam("name") String name) {
		log.entry();

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);

		log.exit();
		return model;

	}
}