package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.AvailableEquipment;
import pl.edu.agh.integracja.common.dto.CurrentStateIDTO;
import pl.edu.agh.integracja.firefighterspost.db.dto.AvailableUnitDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.EquipmentDbDto;

import java.util.List;
import java.util.stream.Collectors;

public class CurrentStateTranslator {

  public CurrentStateIDTO translateFromDbDto(List<EquipmentDbDto> equipment, List<AvailableUnitDbDto> availableUnit) {
    return new CurrentStateIDTO()
        .withAvailableUnits(availableUnit.size())
        .withAvailableEquipment(equipment.stream()
            .map(equipmentDbDto -> new AvailableEquipment()
                    .withName(equipmentDbDto.getName())
                    .withQuantity(equipmentDbDto.getQuantity())
            )
            .collect(Collectors.toList()));
  }
}
