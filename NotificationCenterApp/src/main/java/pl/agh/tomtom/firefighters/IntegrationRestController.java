package pl.agh.tomtom.firefighters;

import generated.integracja.common.dto.NotificationIDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationRestController {

  private static final Logger log = LogManager.getLogger();

  @RequestMapping(value = "/notification", method = RequestMethod.POST)
  public String postNotification(@RequestBody NotificationIDTO notification) {
    log.info(notification.toString());
    return "OK";
  }

}
