package pl.agh.tomtom.firefighters.services;

import java.util.List;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FireNotificationService {
	public void saveFireNotification(FireNotificationDTO notificationDTO) throws FireException;

	public List<FireNotificationDTO> getAllNotifications();

	public FireNotificationDTO get(Long id) throws FireException;

	public void updateStateOfFireNotification(Long id, String newState) throws FireException;

}
