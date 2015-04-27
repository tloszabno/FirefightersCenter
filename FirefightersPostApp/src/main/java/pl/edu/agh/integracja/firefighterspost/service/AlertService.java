package pl.edu.agh.integracja.firefighterspost.service;

import org.apache.log4j.Logger;
import pl.edu.agh.integracja.firefighterspost.view.AlertListener;

import javax.annotation.Resource;

public class AlertService {

    Logger LOG = Logger.getLogger(AlertService.class);
    @Resource(name = "mainAppPane")
    private AlertListener alertListener;

    public void performAlarm() {
        alertListener.onAlertReceive("alert message");
        LOG.info("ALARM!!!!!!");

    }

}
