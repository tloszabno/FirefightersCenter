package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.CurrentStateIDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface FirefightersPostDownloader {

	CurrentStateIDTO getCurrentState(String systemIpAddress) throws FireException;
}
