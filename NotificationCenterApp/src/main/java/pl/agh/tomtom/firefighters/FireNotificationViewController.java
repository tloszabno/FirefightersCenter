package pl.agh.tomtom.firefighters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.services.FireNotificationService;

@Controller
public class FireNotificationViewController {
	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("fireNotificationService")
	private FireNotificationService fireNotificationService;

	@RequestMapping(value = "allFireNotification.htm")
	public ModelAndView allFireNotifications() {
		log.entry();

		ModelAndView mav = FirefightersViewHelper.createMAV("allFireNotificationView");

		/*
		 * FireNotificationDTO notification1 = new FireNotificationDTO();
		 * notification1.setAddress("Dabrawskiego");
		 * notification1.setCreator(AuthUtils.getUserLogin());
		 * notification1.setFinishDate(new Date());
		 * notification1.setNotificationDate(new Date());
		 * notification1.setId(1l); notification1.setCity("Zabno");
		 * notification1.setDescription("To jest opis");
		 * notification1.setActionState("NOWA");
		 * notification1.setType("Pozar lasu"); FireNotificationDTO
		 * notification2 = new FireNotificationDTO();
		 * notification2.setAddress("Lwowska");
		 * notification2.setCreator(AuthUtils.getUserLogin());
		 * notification2.setFinishDate(new Date());
		 * notification2.setNotificationDate(new Date());
		 * notification2.setId(2l); notification2.setCity("Tarnow");
		 * notification2.setDescription("To jest opis");
		 * notification2.setActionState("NOWA");
		 * notification2.setType("Pozar lasu"); List<FireNotificationDTO>
		 * notifications = new ArrayList<FireNotificationDTO>();
		 * notifications.add(notification1); notifications.add(notification2);
		 */
		mav.addObject("notifications", fireNotificationService.getAllNotifications());

		log.exit(mav);
		return mav;
	}
}
