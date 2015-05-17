package pl.edu.agh.integracja.firefighterspost.service;

import org.apache.log4j.Logger;
import pl.edu.agh.integracja.firefighterspost.dao.AlertDao;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;
import pl.edu.agh.integracja.firefighterspost.rest.dto.AlertNotificationRestDto;
import pl.edu.agh.integracja.firefighterspost.translator.AlertTranslator;
import pl.edu.agh.integracja.firefighterspost.view.AlertListener;

import javax.annotation.Resource;

public class AlertService {

  Logger LOG = Logger.getLogger(AlertService.class);

  @Resource(name = "alertDao")
  private AlertDao alertDao;

  @Resource(name = "mainAppPane")
  private AlertListener alertListener;

  @Resource(name = "alertTranslator")
  private AlertTranslator alertTranslator;

  public void performAlarm(AlertNotificationRestDto alertRestDto) {
    AlertNotificationDbDto alertNotificationDbDto = alertTranslator.fromRestToDbModel(alertRestDto);
    alertDao.storeAlert(alertNotificationDbDto);
    alertListener.onAlertReceive(alertRestDto.getName());
    LOG.info("ALARM: " + alertRestDto.getName());
    LOG.info(alertRestDto);

  }

}
