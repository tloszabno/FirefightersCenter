package pl.agh.tomtom.firefighters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.dto.EquipmentReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefighterReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersBrigadeReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
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
		mav.addObject("possibleReports", getSampleData());

		log.exit(mav);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "viewReport.htm")
	public ModelAndView viewReport(@RequestParam Long id) {
		log.entry();

		ModelAndView mav = FirefightersViewHelper
				.createMAV("viewReportDropbox");
		mav.addObject("reportId", id);
		mav.addObject("report", getSampleData().get(0));

		log.exit(mav);
		return mav;
	}

	private List<ReportDTO> getSampleData() {
		List<ReportDTO> actionsReports = new ArrayList<ReportDTO>();

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

		FirefightersPostDTO post = new FirefightersPostDTO();
		post.setAddress("Rynek");
		post.setCity("Zabno");
		post.setCommunity("Zabno");
		post.setName("OPS w Zabnie");

		ReportDTO report1 = new ReportDTO();
		report1.setCommunity("Zabno");
		report1.setCreator(AuthUtils.getUserLogin());
		report1.setObject("Stodola");
		report1.setNotificationType("Wezwanie");
		report1.setOtherDamage("Pekla opona");
		report1.setSize(100.0);
		report1.setOwner("Ziutek");
		report1.setFireNotification(notification1);
		report1.setFirefightersPost(post);
		report1.setId(1L);

		FirefightersBrigadeReportEntryDTO fb1 = new FirefightersBrigadeReportEntryDTO();
		fb1.setArrivalTime(new Date());
		fb1.setDepartureTime(new Date());
		fb1.setDistanceKM(10);
		fb1.setId(2L);
		fb1.setName("Janusze");
		fb1.setPumpWorktime(0);
		fb1.setMemberNumber(2);
		fb1.setTankSource("Hydrant");
		report1.setFirefightersBrigades(Collections.singletonList(fb1));

		FirefighterReportEntryDTO fireman = new FirefighterReportEntryDTO()
				.setFirstName("Janusz").setSurname("Sit").setId(1L);
		report1.setFiremans(Collections.singletonList(fireman));

		actionsReports.add(report1);
		actionsReports.add(report1);

		EquipmentReportEntryDTO eq = new EquipmentReportEntryDTO();
		eq.setEquipmentType("Pompa wodna").setFuelType("Benzyna")
				.setWorkTimeH(10.0).setId(10L);
		report1.setEquipment(Collections.singletonList(eq));

		return actionsReports;
	}
}
