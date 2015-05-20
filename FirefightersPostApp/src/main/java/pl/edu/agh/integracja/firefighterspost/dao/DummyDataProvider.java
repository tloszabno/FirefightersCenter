package pl.edu.agh.integracja.firefighterspost.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.integracja.firefighterspost.db.dto.AvailableUnitDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.EquipmentDbDto;

public class DummyDataProvider extends BaseDao {

  @Transactional
  public void storeDummyPostResources() {
    storeEquipment();
    storeUnits();
  }

  private void storeEquipment() {
    EquipmentDbDto equipmentDbDto = new EquipmentDbDto();
    equipmentDbDto.setName("Woz bojowy");
    equipmentDbDto.setQuantity(3);
    getCurrentSession().save(equipmentDbDto);

    equipmentDbDto = new EquipmentDbDto();
    equipmentDbDto.setName("Helikopter");
    equipmentDbDto.setQuantity(1);
    getCurrentSession().save(equipmentDbDto);

    equipmentDbDto = new EquipmentDbDto();
    equipmentDbDto.setName("Gasnica");
    equipmentDbDto.setQuantity(6);
    getCurrentSession().save(equipmentDbDto);

    equipmentDbDto = new EquipmentDbDto();
    equipmentDbDto.setName("Piasek do Oleju");
    equipmentDbDto.setQuantity(10);
    getCurrentSession().save(equipmentDbDto);
  }

  private void storeUnits() {
    AvailableUnitDbDto availableUnitDbDto = new AvailableUnitDbDto();
    availableUnitDbDto.setName("zastep 1");
    getCurrentSession().save(availableUnitDbDto);

    availableUnitDbDto = new AvailableUnitDbDto();
    availableUnitDbDto.setName("zastep 2");
    getCurrentSession().save(availableUnitDbDto);

    availableUnitDbDto = new AvailableUnitDbDto();
    availableUnitDbDto.setName("zastep 3");
    getCurrentSession().save(availableUnitDbDto);

    availableUnitDbDto = new AvailableUnitDbDto();
    availableUnitDbDto.setName("zastep 4");
    getCurrentSession().save(availableUnitDbDto);
  }

}
