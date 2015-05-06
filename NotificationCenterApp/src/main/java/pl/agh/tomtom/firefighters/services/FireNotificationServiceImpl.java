package pl.agh.tomtom.firefighters.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.agh.tomtom.firefighters.assemblers.FireNotificationAssembler;
import pl.agh.tomtom.firefighters.dao.FireNotificationDAO;
import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;
import pl.agh.tomtom.firefighters.model.FireNotification;

@Transactional(propagation = Propagation.REQUIRED)
public class FireNotificationServiceImpl implements FireNotificationService {
	private static final Logger log = LogManager.getLogger();

	@Autowired
	private FireNotificationDAO fireNotificationDAO;

	@Override
	public void saveFireNotification(FireNotificationDTO notificationDTO) throws FireException {
		log.entry(notificationDTO);

		Long id = notificationDTO.getId();
		FireNotification fireNotification = null;
		if (id != null) {
			fireNotification = fireNotificationDAO.get(id);
			if (fireNotification == null) {
				throw new FireException("Notification with id=[" + id + "] not found");
			}
		} else {
			fireNotification = new FireNotification();
		}

		FireNotificationAssembler.fillModelWithDTO(fireNotification, notificationDTO);

		fireNotificationDAO.saveOrUpdate(fireNotification);

		log.exit();
	}

	@Override
	public List<FireNotificationDTO> getAllNotifications() {
		log.entry();

		List<FireNotification> notifications = fireNotificationDAO.list();
		List<FireNotificationDTO> dtos = notifications.stream().map(s -> FireNotificationAssembler.fromModel(s))
				.collect(Collectors.toList());

		log.exit(dtos);
		return dtos;
	}
}
