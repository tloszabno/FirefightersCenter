package pl.edu.agh.integracja.firefighterspost.handler;

import org.apache.log4j.Logger;
import pl.edu.agh.integracja.common.dto.FireNotificationIDTO;
import pl.edu.agh.integracja.firefighterspost.dao.AlertDao;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;
import pl.edu.agh.integracja.firefighterspost.translator.AlertTranslator;
import pl.edu.agh.integracja.firefighterspost.view.AlertListener;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class PostFireNotificationHandler {

  Logger LOG = Logger.getLogger(PostFireNotificationHandler.class);

  @Resource(name = "alertDao")
  private AlertDao alertDao;

  @Resource(name = "alertTranslator")
  private AlertTranslator alertTranslator;
  
  private List<AlertListener> alertListeners = new ArrayList<>();

  public void addAlertHandler(AlertListener alertListener) {
    alertListeners.add(alertListener);
  }

  public String handle(FireNotificationIDTO fireNotificationIDTO) {
    AlertNotificationDbDto alertNotificationDbDto = alertTranslator.fromRestToDbModel(fireNotificationIDTO);
    alertDao.storeAlert(alertNotificationDbDto);

    alertListeners.forEach(listener -> listener.onAlertReceive(fireNotificationIDTO.getActionName()));

    LOG.info("ALARM: " + fireNotificationIDTO.getActionName());
    LOG.info(fireNotificationIDTO);

    return "OK";
  }

}
