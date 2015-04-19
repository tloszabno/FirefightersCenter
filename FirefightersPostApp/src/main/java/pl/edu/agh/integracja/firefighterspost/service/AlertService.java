package pl.edu.agh.integracja.firefighterspost.service;

import org.apache.log4j.Logger;

public class AlertService {

    Logger LOG = Logger.getLogger(AlertService.class);

    public void performAlarm() {
        LOG.info("ALARM!!!!!!");
    }
}
