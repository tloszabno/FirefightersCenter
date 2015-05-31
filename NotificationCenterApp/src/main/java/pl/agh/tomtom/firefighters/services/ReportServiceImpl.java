package pl.agh.tomtom.firefighters.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.agh.tomtom.firefighters.assemblers.ReportModelDTOAssembler;
import pl.agh.tomtom.firefighters.dao.FireNotificationDAO;
import pl.agh.tomtom.firefighters.dao.FirefightersPostDAO;
import pl.agh.tomtom.firefighters.dao.ReportDAO;
import pl.agh.tomtom.firefighters.dto.EquipmentReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefighterReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersBrigadeReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.dto.ReportDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.model.FireNotification;
import pl.agh.tomtom.firefighters.model.FirefightersPost;
import pl.agh.tomtom.firefighters.model.Report;
import pl.agh.tomtom.firefighters.utils.AuthUtils;

@Transactional(propagation = Propagation.REQUIRED)
public class ReportServiceImpl implements ReportService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	@Qualifier("reportDAO")
	private ReportDAO reportDAO;

	@Autowired
	private FirefightersPostDAO firefightersPostDAO;

	@Autowired
	private FireNotificationDAO fireNotificationDAO;

	@Override
	public List<ReportDTO> getAllReports() {
		log.entry();

		List<Report> reports = reportDAO.list();
		List<ReportDTO> reportsDTOs = reports.stream().map(model -> ReportModelDTOAssembler.fromModel(model))
				.collect(Collectors.toList());

		log.exit(reportsDTOs);
		return reportsDTOs;
	}

	@Override
	public ReportDTO getReport(Long id) throws FireException {
		log.entry();

		Report report = reportDAO.get(id);
		if (report == null) {
			throw new FireException("Report with id=[" + id + "] not exists");
		}

		ReportDTO dto = ReportModelDTOAssembler.fromModel(report);

		log.exit(dto);
		return dto;
	}

	@Override
	public List<ReportDTO> getReportsForNotification(Long notificationId) {
		log.entry();
		List<ReportDTO> reports = getAllReports().stream()
				.filter(r -> r.getFireNotification() != null && r.getFireNotification().getId().equals(notificationId))
				.collect(Collectors.toList());
		log.exit();
		return reports;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveReport(ReportDTO report) throws FireException {
		log.entry(report);

		// report = getSampleData().get(0);
		Report modelReport = ReportModelDTOAssembler.fromDTO(report);

		FirefightersPostDTO firefightersPostDTO = report.getFirefightersPost();
		FirefightersPost firefightersPost = firefightersPostDAO.get(firefightersPostDTO.getId());
		modelReport.setFirefightersPost(firefightersPost);

		FireNotificationDTO fireNotificationDTO = report.getFireNotification();
		FireNotification fireNotification = fireNotificationDAO.get(fireNotificationDTO.getId());
		modelReport.setFireNotification(fireNotification);

		reportDAO.save(modelReport);

		log.exit();
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
		notification1.setId(2L);

		FirefightersPostDTO post = new FirefightersPostDTO();
		post.setAddress("Rynek");
		post.setCity("Zabno");
		post.setCommunity("Zabno");
		post.setName("OPS w Zabnie");
		post.setId(1L);

		ReportDTO report1 = new ReportDTO();
		report1.setCommunity("Zabno");
		report1.setCreator(AuthUtils.getUserLogin());
		report1.setObject("Stodola");
		report1.setNotificationType("Wezwanie");
		report1.setOtherDamage("Pekla opona");
		report1.setSize("100.0");
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

		FirefighterReportEntryDTO fireman = new FirefighterReportEntryDTO().setFirstName("Janusz").setSurname("Sit")
				.setId(1L);
		report1.setFiremans(Collections.singletonList(fireman));

		actionsReports.add(report1);
		actionsReports.add(report1);

		EquipmentReportEntryDTO eq = new EquipmentReportEntryDTO();
		eq.setEquipmentType("Pompa wodna").setFuelType("Benzyna").setWorkTimeH(10.0).setId(10L);
		report1.setEquipment(Collections.singletonList(eq));

		return actionsReports;
	}
}
