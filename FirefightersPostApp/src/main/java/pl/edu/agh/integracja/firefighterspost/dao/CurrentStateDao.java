package pl.edu.agh.integracja.firefighterspost.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.integracja.firefighterspost.db.dto.AvailableUnitDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.EquipmentDbDto;

import java.util.List;

@Transactional
public class CurrentStateDao extends BaseDao {

  public List<EquipmentDbDto> getAvailableEquipment() {
    return getCurrentSession().createQuery("FROM EquipmentDbDto").list();
  }

  public List<AvailableUnitDbDto> getAvailableUnits() {
    return getCurrentSession().createQuery("FROM AvailableUnitDbDto").list();
  }

}
