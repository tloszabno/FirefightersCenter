package pl.edu.agh.integracja.firefighterspost.handler;

import pl.edu.agh.integracja.common.dto.CurrentStateIDTO;
import pl.edu.agh.integracja.firefighterspost.dao.CurrentStateDao;
import pl.edu.agh.integracja.firefighterspost.db.dto.AvailableUnitDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.EquipmentDbDto;
import pl.edu.agh.integracja.firefighterspost.translator.CurrentStateTranslator;

import javax.annotation.Resource;
import java.util.List;

public class GetCurrentStateHandler {

  @Resource(name = "currentStateDao")
  private CurrentStateDao currentStateDao;

  @Resource(name = "currentStateTranslator")
  private CurrentStateTranslator currentStateTranslator;

  public CurrentStateIDTO handle() {
    List<EquipmentDbDto> availableEquipment = currentStateDao.getAvailableEquipment();
    List<AvailableUnitDbDto> availableUnits = currentStateDao.getAvailableUnits();
    return currentStateTranslator.translateFromDbDto(availableEquipment, availableUnits);
  }
}
