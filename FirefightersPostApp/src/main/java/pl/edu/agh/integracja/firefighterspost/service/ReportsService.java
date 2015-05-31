package pl.edu.agh.integracja.firefighterspost.service;

import pl.edu.agh.integracja.common.dto.ReportIDTO;
import pl.edu.agh.integracja.common.dto.ReportListIDTO;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportGuiModel;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportHeaderGuiModel;
import pl.edu.agh.integracja.firefighterspost.translator.ReportsTranslator;

import javax.annotation.Resource;
import java.util.List;

public class ReportsService {

  @Resource(name = "restClient")
  private RestClient restClient;

  @Resource(name = "reportsTranslator")
  private ReportsTranslator reportsTranslator;

  public void sendReport(ReportGuiModel reportGuiModel) {
    ReportIDTO reportIDTO =    reportsTranslator.translateReportFromGuiToRest(reportGuiModel);
    restClient.sendReport(reportIDTO);
  }

  public List<ReportHeaderGuiModel> getReportsList() {
    ReportListIDTO reportsList = restClient.getReportsList();
    return reportsTranslator.translateListFromRestToGui(reportsList);
  }

  public ReportGuiModel getReport(String reportId) {
    ReportIDTO reportIDTO = restClient.getReport(reportId);
    return reportsTranslator.translateReportFromRestToGui(reportIDTO);
  }
}
