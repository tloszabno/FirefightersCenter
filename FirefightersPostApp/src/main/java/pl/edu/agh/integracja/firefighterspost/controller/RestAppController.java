package pl.edu.agh.integracja.firefighterspost.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.integracja.common.dto.CurrentStateIDTO;
import pl.edu.agh.integracja.common.dto.FireNotificationIDTO;
import pl.edu.agh.integracja.firefighterspost.config.Config;
import pl.edu.agh.integracja.firefighterspost.handler.GetCurrentStateHandler;
import pl.edu.agh.integracja.firefighterspost.handler.PostFireNotificationHandler;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@Import(value = Config.class)
public class RestAppController {

  @Resource(name = "getCurrentStateHandler")
  private GetCurrentStateHandler getCurrentStateHandler;

  @Resource(name = "postFireNotificationHandler")
  private PostFireNotificationHandler postFireNotificationHandler;

  @RequestMapping(value = "/currentstate", method = RequestMethod.GET)
  public CurrentStateIDTO getCurrentState() {
    return getCurrentStateHandler.handle();
  }

  @RequestMapping(value = "/fireNotification", method = RequestMethod.POST)
  public String postFireNotification(@RequestBody FireNotificationIDTO fireNotificationIDTO) {
    return postFireNotificationHandler.handle(fireNotificationIDTO);
  }

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  public String ping() {
    return "pong";
  }

}

