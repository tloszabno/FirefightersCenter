package pl.edu.agh.integracja.firefighterspost.service;

import pl.edu.agh.integracja.common.dto.ReportListIDTO;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportHeaderGuiModel;
import pl.edu.agh.integracja.firefighterspost.translator.ReportsTranslator;

import javax.annotation.Resource;
import java.util.List;

public class ReportsService {

  @Resource(name = "restClient")
  private RestClient restClient;

  @Resource(name = "reportsTranslator")
  private ReportsTranslator reportsTranslator;

  public void sendReport() {
  }

  public List<ReportHeaderGuiModel> getReportsList() {
    ReportListIDTO reportsList = restClient.getReportsList();
    return reportsTranslator.fromRestToGui(reportsList);
  }

}
