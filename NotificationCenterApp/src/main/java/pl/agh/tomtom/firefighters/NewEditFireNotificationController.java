package pl.agh.tomtom.firefighters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewEditFireNotificationController {

	private static final Logger log = LogManager.getLogger();

	@RequestMapping(value = "/newFireNotication.htm", method = RequestMethod.GET)
	public ModelAndView newFireNotification() {
		log.entry();

		ModelAndView model = FirefightersViewHelper
				.createMAV("newEditFireNotication");

		log.exit();
		return model;
	}
}
