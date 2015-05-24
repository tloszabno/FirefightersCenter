package pl.edu.agh.integracja.firefighterspost.service;

import pl.edu.agh.integracja.common.dto.NotificationIDTO;

import javax.annotation.Resource;

public class NotificationsService {

  @Resource(name = "restClient")
  private RestClient restClient;

  public void confirmAlert(Long externalId) {
    NotificationIDTO requestBody = new NotificationIDTO();
    requestBody.setId(externalId.toString());
    requestBody.setState(NotificationIDTO.State.CONFIRMED);
    restClient.notifyCenter(requestBody);
  }

  public void finishAlert(Long externalId) {
    NotificationIDTO requestBody = new NotificationIDTO();
    requestBody.setId(externalId.toString());
    requestBody.setState(NotificationIDTO.State.FINISHED);
    restClient.notifyCenter(requestBody);
  }

  public void getReport() {
    restClient.getReport();
  }


}
