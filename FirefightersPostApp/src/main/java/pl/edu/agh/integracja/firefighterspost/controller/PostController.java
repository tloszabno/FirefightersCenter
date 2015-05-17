package pl.edu.agh.integracja.firefighterspost.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.integracja.firefighterspost.config.Config;
import pl.edu.agh.integracja.firefighterspost.rest.dto.AlertNotificationRestDto;
import pl.edu.agh.integracja.firefighterspost.service.AlertService;

import javax.annotation.Resource;

@Controller
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

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String home() {
    return "Home Page";
  }

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  @ResponseBody
  public String ping() {
    return "Hello World!";
  }

  @RequestMapping(value = "/alert", method = RequestMethod.POST)
  public
  @ResponseBody
  String alert(@RequestBody AlertNotificationRestDto alertNotificationDTO) {
    alertService.performAlarm(alertNotificationDTO);

    return "Alert Registered.";
  }
}

