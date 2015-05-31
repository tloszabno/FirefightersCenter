package pl.agh.tomtom.firefighters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.services.ReportService;

@Controller
public class ReportsViewController {
	private static final Logger log = LogManager.getLogger(ReportsViewController.class);

	@Autowired
	@Qualifier("reportService")
	private ReportService reportService;

	@RequestMapping(method = RequestMethod.GET, value = "showPossibleReports.htm")
	public ModelAndView showPossibleReports(@RequestParam Long notificationId) throws FireException {
		log.entry();

		// reportService.saveReport(null);

		ModelAndView mav = FirefightersViewHelper.createMAV("possibleReportsDropbox");
		mav.addObject("notificationId", notificationId);
		mav.addObject("possibleReports", reportService.getReportsForNotification(notificationId));

		log.exit(mav);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "viewReport.htm")
	public ModelAndView viewReport(@RequestParam Long id) throws FireException {
		log.entry();

		ModelAndView mav = FirefightersViewHelper.createMAV("viewReportDropbox");
		mav.addObject("reportId", id);
		mav.addObject("report", reportService.getReport(id));

		log.exit(mav);
		return mav;
	}

}
