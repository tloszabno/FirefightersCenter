package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.AvailableEquipment;
import generated.integracja.common.dto.CurrentStateIDTO;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pl.agh.tomtom.firefighters.exceptions.FireException;

public class FirefightersPostDownloaderImpl implements FirefightersPostDownloader {
	private static final Logger log = LogManager.getLogger();

	@Override
	public CurrentStateIDTO getCurrentState(String systemIpAddress) throws FireException {
		log.entry();

		log.exit();
		return getSample();
	}

	private CurrentStateIDTO getSample() {
		List<AvailableEquipment> availableEquipment = new ArrayList<>();
		availableEquipment.add(new AvailableEquipment().withName("drabina").withQuantity(3));
		availableEquipment.add(new AvailableEquipment().withName("helikopter").withQuantity(1));
		availableEquipment.add(new AvailableEquipment().withName("pompa").withQuantity(1));
		return new CurrentStateIDTO().withAvailableUnits(2).withAvailableEquipment(availableEquipment);
	}
}
