package pl.agh.tomtom.firefighters;

import generated.integracja.common.dto.*;
import org.springframework.web.bind.annotation.*;
import pl.agh.tomtom.firefighters.assemblers.ReportHeaderAssembler;
import pl.agh.tomtom.firefighters.assemblers.ReportIDTOAssembler;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.dto.ReportDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.services.FireNotificationService;
import pl.agh.tomtom.firefighters.services.FirefightersPostService;
import pl.agh.tomtom.firefighters.services.ReportService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class IntegrationRestController {

  @Resource(name = "fireNotificationService")
  private FireNotificationService fireNotificationService;

  @Resource(name = "reportService")
  private ReportService reportService;

  @Resource(name = "firefightersPostService")
  private FirefightersPostService firefightersPostService;

  @RequestMapping(value = "/notification", method = RequestMethod.POST)
  public String postNotification(@RequestBody NotificationIDTO notification) throws FireException {
    fireNotificationService.updateStateOfFireNotification(Long.valueOf(notification.getId()), notification.getState().name());
    return "OK - " + notification.getState();
  }

  @RequestMapping(value = "/report", method = RequestMethod.POST)
  public String postReport(@RequestBody ReportIDTO report) throws FireException {
    ReportDTO reportInternal = ReportIDTOAssembler.fromIDTOModel(report);

    FirefightersPostDTO firefightersPostDTO = firefightersPostService.getByName(report.getPostName());
    reportInternal.setFirefightersPost(firefightersPostDTO);

    reportService.saveReport(reportInternal);

    return "OK - report saved.";
  }

  @RequestMapping(value = "/reports", method = RequestMethod.GET)
  public ReportListIDTO getReports(@RequestParam(value = "postName", required = true) String postName) {

    List<ReportDTO> allReports = reportService.getAllReports();
    return ReportHeaderAssembler.fromReportsListToHeaders(allReports);
  }

  private ReportListIDTO getDummyReportsList() {
    ReportListIDTO reportsList = new ReportListIDTO();
    reportsList.withReportHeaders(Arrays.asList(
        new ReportHeader()
            .withActionName("Pozar krk")
            .withAddress("Krakow Czarnowiejska")
            .withNotificationDate("2015-04-12T12:33:00")
            .withReportId("123"),
        new ReportHeader()
            .withActionName("Pozar S7")
            .withAddress("Krakow S7 34 km")
            .withNotificationDate("2015-02-11T3:33:00")
            .withReportId("58523")
    ));

    return reportsList;
  }

  @RequestMapping(value = "/report", method = RequestMethod.GET)
  public ReportIDTO getReport(@RequestParam(value = "reportId", required = true) String reportId) throws FireException {
    ReportDTO reportDTO = reportService.getReport(Long.parseLong(reportId));
    return ReportIDTOAssembler.toIDTOModel(reportDTO);
  }

  private ReportIDTO getDummyReport() {
    ReportIDTO report = new ReportIDTO()
        .withAccidentType("Pożar")
        .withActionName("Pożark na S7")
        .withAreaSize("2km")
        .withBrigades(Arrays.asList(
            new Brigade()
                .withArrivalTime(new Date())
                .withDepartureTime(new Date())
                .withDistanceInKm(21)
                .withMembersNumber(4)
                .withName("brygada 3")
                .withPumpworkTime("3"),
            new Brigade()
                .withArrivalTime(new Date())
                .withDepartureTime(new Date())
                .withDistanceInKm(24)
                .withMembersNumber(7)
                .withName("brygada 24")
                .withPumpworkTime("7")
        ))
        .withCommunity("Kraków")
        .withCreator("Jan Kowalski")
        .withFirefighters(Arrays.asList(
            new Firefighter()
                .withName("Jan1")
                .withSurname("Kowalski1"),
            new Firefighter()
                .withName("Jan2")
                .withSurname("Kowalski2"),
            new Firefighter()
                .withName("Jan3")
                .withSurname("Kowalski3"),
            new Firefighter()
                .withName("Jan4")
                .withSurname("Kowalski4")
        ))
        .withNotificationId("23151")
        .withObjectName("Droga Krajowa")
        .withOtherDamages(Arrays.asList(
            new OtherDamage().withDamageName("Przebite 3 koła"),
            new OtherDamage().withDamageName("Popsuta gaśnica"),
            new OtherDamage().withDamageName("Uszkodzona drabina")
        ))
        .withOwner("GDDKiA")
        .withPostName("OSP Bieżanów")
        .withUsedEquipment(Arrays.asList(
            new UsedEquipment()
                .withName("Gaśnica")
                .withFuelType("-")
                .withWorkTimeInH(3),
            new UsedEquipment()
                .withName("Helikopter")
                .withFuelType("Paliwo Lotnicze")
                .withWorkTimeInH(5),
            new UsedEquipment()
                .withName("Wóz bojowy")
                .withFuelType("ON")
                .withWorkTimeInH(8)
        ));
    return report;
  }

}
