package pl.edu.agh.integracja.firefighterspost.dao;

import pl.edu.agh.integracja.firefighterspost.db.dto.AvailableUnitDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.EquipmentDbDto;

import java.util.ArrayList;
import java.util.List;

public class CurrentStateDao extends BaseDao {

  public List<EquipmentDbDto> getAvailableEquipment() {
    ArrayList<EquipmentDbDto> equipmentDbDtos = new ArrayList<>();
    EquipmentDbDto equipmentDbDto = new EquipmentDbDto();
    equipmentDbDto.setName("Gasnica");
    equipmentDbDto.setQuantity(6);
    equipmentDbDtos.add(equipmentDbDto);
    return equipmentDbDtos;
  }

  public List<AvailableUnitDbDto> getAvailableUnits() {
    List<AvailableUnitDbDto> availableUnits = new ArrayList<>();
    availableUnits.add(new AvailableUnitDbDto());
    availableUnits.add(new AvailableUnitDbDto());
    availableUnits.add(new AvailableUnitDbDto());
    return availableUnits;
  }

}
