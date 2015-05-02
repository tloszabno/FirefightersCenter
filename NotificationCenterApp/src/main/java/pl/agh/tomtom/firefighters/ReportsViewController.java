package pl.agh.tomtom.firefighters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FireNotificationReportDTO;
import pl.agh.tomtom.firefighters.dto.ReportDTO;
import pl.agh.tomtom.firefighters.utils.AuthUtils;

@Controller
public class ReportsViewController {
	private static final Logger log = LogManager
			.getLogger(ReportsViewController.class);

	@RequestMapping(method = RequestMethod.GET, value = "showPossibleReports.htm")
	public ModelAndView showPossibleReports(@RequestParam Long notificationId) {
		log.entry();

		ModelAndView mav = FirefightersViewHelper
				.createMAV("possibleReportsDropbox");
		mav.addObject("notificationId", notificationId);

		log.exit(mav);
		return mav;
	}

	@RequestMapping(value = "/allReportsView.htm")
	public ModelAndView allReportsView() {
		log.entry();

		ModelAndView mav = FirefightersViewHelper.createMAV("allReportsView");
		List<FireNotificationReportDTO> data = getSampleData();
		mav.addObject("actionReports", data);

		log.exit(mav);
		return mav;
	}

	private List<FireNotificationReportDTO> getSampleData() {
		List<FireNotificationReportDTO> actionsReports = new ArrayList<FireNotificationReportDTO>();

		FireNotificationDTO notification1 = new FireNotificationDTO();
		notification1.setAddress("Dabrawskiego");
		notification1.setCreator(AuthUtils.getUserLogin());
		notification1.setFinishDate(null);
		notification1.setNotificationDate(new Date());
		notification1.setId(1l);
		notification1.setCity("Zabno");
		notification1.setDescription("To jest opis");
		notification1.setActionState("FINISHED");
		notification1.setType("Pozar lasu");

		FireNotificationReportDTO actionReport1 = new FireNotificationReportDTO();
		actionReport1.setNotification(notification1);
		ReportDTO report1 = new ReportDTO();
		actionReport1.addReport(report1);
		report1.setCommunity("Zabno");
		report1.setCreator(AuthUtils.getUserLogin());
		report1.setObject("Stodola");
		report1.setNotificationType("Wezwanie");
		report1.setOtherDamage("Pekla opona");
		report1.setSize(100.0);
		report1.setOwner("Ziutek");
		report1.setFireNotification(notification1);

		actionsReports.add(actionReport1);
		return actionsReports;
	}
}
