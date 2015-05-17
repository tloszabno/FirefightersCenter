package pl.edu.agh.integracja.firefighterspost.dao;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;

public class AlertDao extends BaseDao {

  @Transactional
  public void storeAlert(AlertNotificationDbDto alertNotification) {
    getCurrentSession().save(alertNotification);
  }

}
