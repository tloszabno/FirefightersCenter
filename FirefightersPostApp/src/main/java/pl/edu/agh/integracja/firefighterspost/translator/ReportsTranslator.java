package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.ReportListIDTO;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportHeaderGuiModel;

import java.util.List;
import java.util.stream.Collectors;

public class ReportsTranslator {

  public List<ReportHeaderGuiModel> fromRestToGui(ReportListIDTO reportsList) {
    return reportsList.getReportHeaders().stream()
        .map(rest -> new ReportHeaderGuiModel(rest.getReportId(), rest.getNotificationDate(), rest.getActionName(), rest.getAddress()))
        .collect(Collectors.toList());
  }
}
