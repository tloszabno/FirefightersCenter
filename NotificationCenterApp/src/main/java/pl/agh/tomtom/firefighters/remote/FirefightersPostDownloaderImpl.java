package pl.agh.tomtom.firefighters.remote;

import generated.integracja.common.dto.AvailableEquipment;
import generated.integracja.common.dto.CurrentStateIDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.agh.tomtom.firefighters.exceptions.FireException;

import java.util.ArrayList;
import java.util.List;

public class FirefightersPostDownloaderImpl implements FirefightersPostDownloader {
  private static final Logger log = LogManager.getLogger();

  @Override
  public CurrentStateIDTO getCurrentState(String systemIpWithPost) throws FireException {
    log.entry();
    CurrentStateIDTO currentStateIDTO;

    String url = FirefightersPostUrlProvider.getFullUrlValue(systemIpWithPost, "currentstate");
    try {
      currentStateIDTO = new RestTemplate().getForObject(url, CurrentStateIDTO.class);
    } catch (RestClientException e) {
      log.error("error when retrieving current state from: " + url, e);
      currentStateIDTO = getSample();
    }

    log.exit();
    return currentStateIDTO;
  }

  private CurrentStateIDTO getSample() {
    List<AvailableEquipment> availableEquipment = new ArrayList<>();
    availableEquipment.add(new AvailableEquipment().withName("drabina").withQuantity(3));
    availableEquipment.add(new AvailableEquipment().withName("helikopter").withQuantity(1));
    availableEquipment.add(new AvailableEquipment().withName("pompa").withQuantity(1));
    return new CurrentStateIDTO().withAvailableUnits(2).withAvailableEquipment(availableEquipment);
  }
}
