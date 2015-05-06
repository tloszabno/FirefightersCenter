package pl.agh.tomtom.firefighters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.services.FireNotificationService;

@Controller
public class NewEditFireNotificationController {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("fireNotificationService")
	private FireNotificationService fireNotificationService;

	@RequestMapping(value = "/newFireNotication.htm", method = RequestMethod.GET)
	public ModelAndView newFireNotification(@RequestParam(required = false) Long id) {
		log.entry();

		ModelAndView model = FirefightersViewHelper.createMAV("newEditFireNotication");

		model.addObject("isEdit", Boolean.toString(id != null));
		model.addObject("editNotificationId", id);

		log.exit();
		return model;
	}

	@RequestMapping(value = "saveFireNotification", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String saveFireNotification(@RequestBody FireNotificationDTO notificationDTO)
			throws FireException {
		log.entry(notificationDTO);

		fireNotificationService.saveFireNotification(notificationDTO);

		log.exit();
		return "OK";
	}

}
