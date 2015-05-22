package pl.edu.agh.integracja.firefighterspost.service;

import javax.annotation.Resource;

public class NotificationsService {

  @Resource(name = "restClient")
  private RestClient restClient;

  public void confirmAlert() {

    restClient.notifyCenter();
    restClient.getReport();

  }
}
