package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;
import pl.edu.agh.integracja.firefighterspost.rest.dto.AlertNotificationRestDto;

public class AlertTranslator {

  public AlertNotificationDbDto fromRestToDbModel(AlertNotificationRestDto restDto) {
    AlertNotificationDbDto dbDto = new AlertNotificationDbDto();
    dbDto.setName(restDto.getName());

    return dbDto;

  }
}
