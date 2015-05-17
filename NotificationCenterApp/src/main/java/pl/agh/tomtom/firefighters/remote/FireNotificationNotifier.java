package pl.agh.tomtom.firefighters.remote;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FireNotificationNotifier {
	public void sendNotification(FireNotificationDTO fireNotification, FirefightersPostDTO destination)
			throws FireException;

}
