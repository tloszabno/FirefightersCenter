package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.CurrentStateIDTO;
import generated.integracja.common.dto.FireNotificationIDTO;

import org.apache.logging.log4j.Logger;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.agh.tomtom.firefighters.exceptions.FireException;

import java.net.URI;

public class FireNotificationNotifierImpl implements FireNotificationNotifier {

	private static final Logger log = org.apache.logging.log4j.LogManager.getLogger();

	@Override
	public void sendNotification(FireNotificationIDTO fireNotification, String systemIpWithPost) throws FireException {
		log.entry(fireNotification, systemIpWithPost);

		String url = FirefightersPostUrlProvider.getFullUrlValue(systemIpWithPost, "fireNotification");
		try {
			new RestTemplate().postForLocation(url, fireNotification);
		} catch (RestClientException e) {
			log.error("error when sending fire notification to: " + url, e);
		}

		log.exit();
	}

}
