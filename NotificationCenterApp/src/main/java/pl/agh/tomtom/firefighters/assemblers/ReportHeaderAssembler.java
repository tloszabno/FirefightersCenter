package pl.agh.tomtom.firefighters.assemblers;

import generated.integracja.common.dto.ReportHeader;
import generated.integracja.common.dto.ReportListIDTO;
import pl.agh.tomtom.firefighters.dto.ReportDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReportHeaderAssembler {

  public static ReportListIDTO fromReportsListToHeaders(List<ReportDTO> allReports){

    return new ReportListIDTO()
        .withReportHeaders(allReports.stream()
            .map(report -> new ReportHeader()
                    .withActionName(report.getFireNotification().getType())
                    .withAddress(report.getFireNotification().getAddress())
                    .withNotificationDate(report.getFireNotification().getNotificationDate().toString())
                    .withReportId(report.getId().toString())
            ).collect(Collectors.toList()));

  }
}
