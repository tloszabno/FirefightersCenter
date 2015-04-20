package pl.agh.tomtom.firefighters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class FirefightersViewHelper {

	private final static Map<String, String> msgs = new HashMap<String, String>();

	static {
		msgs.put("newNotificationBtnMsg", "Nowe zgloszenie");
		msgs.put("notifitacionBtnMsg", "Zgloszenia");
		msgs.put("stationsBtnMsg", "Posterunki");
		msgs.put("reportsBtnMsg", "Raporty");
	}

	public static final ModelAndView createMAV(String viewName) {
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("text", msgs);
		return mav;
	}
}
