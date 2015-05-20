package pl.edu.agh.integracja.firefighterspost.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.integracja.common.dto.CurrentStateIDTO;
import pl.edu.agh.integracja.common.dto.FireNotificationIDTO;
import pl.edu.agh.integracja.firefighterspost.config.Config;
import pl.edu.agh.integracja.firefighterspost.service.AlertService;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@Import(value = Config.class)
public class PostController {

  private AlertService alertService;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(PostController.class, args);
  }

  @Resource(name = "alertService")
  public void setAlertService(AlertService alertService) {
    this.alertService = alertService;
  }

  @RequestMapping(value = "/currentstate", method = RequestMethod.GET)
  public CurrentStateIDTO getCurrentState() {
    CurrentStateIDTO currentStateIDTO = new CurrentStateIDTO();
    return currentStateIDTO;
  }

  @RequestMapping(value = "/fireNotification", method = RequestMethod.POST)
  public String postFireNotification(@RequestBody FireNotificationIDTO fireNotificationIDTO) {
    return "OK";
  }

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  public String ping() {
    return "pong";
  }

}

