package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.FireNotificationIDTO;

import org.apache.logging.log4j.Logger;

import pl.agh.tomtom.firefighters.exceptions.FireException;

public class FireNotificationNotifierImpl implements FireNotificationNotifier {

	private static final Logger log = org.apache.logging.log4j.LogManager.getLogger();

	@Override
	public void sendNotification(FireNotificationIDTO fireNotification, String systemIp) throws FireException {
		log.entry(fireNotification, systemIp);

		// FIXME: here notify firestation

		log.exit();
	}

}
