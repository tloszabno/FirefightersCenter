package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.FireNotificationIDTO;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;

public class AlertTranslator {

  public AlertNotificationDbDto fromRestToDbModel(FireNotificationIDTO restDto) {
    AlertNotificationDbDto dbDto = new AlertNotificationDbDto();
    dbDto.setName(restDto.getActionName());

    return dbDto;

  }
}
