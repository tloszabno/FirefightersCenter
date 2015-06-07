package pl.edu.agh.integracja.firefighterspost.service;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.integracja.common.dto.NotificationIDTO;
import pl.edu.agh.integracja.common.dto.ReportIDTO;
import pl.edu.agh.integracja.common.dto.ReportListIDTO;
import pl.edu.agh.integracja.firefighterspost.config.EndpointConfig;

import java.util.HashMap;

public class RestClient {

  Logger logger = Logger.getLogger(RestClient.class);

  public void sendReport(ReportIDTO report) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForLocation(getFullUrl("report"), report);
  }

  public ReportListIDTO getReportsList() {
    RestTemplate restTemplate = new RestTemplate();
    HashMap<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("postName", "foobar");
    ReportListIDTO reportIDTO = restTemplate.getForObject(getFullUrl("reports?postName={postName}"), ReportListIDTO.class, urlVariables);
    return reportIDTO;
  }

  public ReportIDTO getReport(String reportId) {
    RestTemplate restTemplate = new RestTemplate();
    HashMap<String, Object> urlVariables = new HashMap<>();
    urlVariables.put("reportIdValue", reportId);
    ReportIDTO report = restTemplate.getForObject(getFullUrl("report?reportId={reportIdValue}"), ReportIDTO.class, urlVariables);
    logger.info(report.toString());
    return report;
  }

  public void notifyCenter(NotificationIDTO request) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForLocation(getFullUrl("notification"), request);
  }

  private String getFullUrl(String path) {
    return "http://" + EndpointConfig.NOTIFICATION_CENTER_IP + ":8080/NotificationCenterApp/" + path;
  }

}
