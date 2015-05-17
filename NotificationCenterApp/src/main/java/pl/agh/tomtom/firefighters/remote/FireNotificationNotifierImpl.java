package pl.agh.tomtom.firefighters.remote;

import org.apache.logging.log4j.Logger;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public class FireNotificationNotifierImpl implements FireNotificationNotifier {

	private static final Logger log = org.apache.logging.log4j.LogManager.getLogger();

	@Override
	public void sendNotification(FireNotificationDTO fireNotification, FirefightersPostDTO destination)
			throws FireException {
		log.entry(fireNotification, destination);

		// FIXME: here notify firestation

		log.exit();
	}

}
