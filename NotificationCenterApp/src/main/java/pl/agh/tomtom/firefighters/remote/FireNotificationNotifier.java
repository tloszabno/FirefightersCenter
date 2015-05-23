package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.FireNotificationIDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FireNotificationNotifier {
	public void sendNotification(FireNotificationIDTO idto, String systemIp) throws FireException;

}
