package pl.agh.tomtom.firefighters.assemblers;

import generated.integracja.common.dto.FireNotificationIDTO;
import generated.integracja.common.dto.OrderedResource;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;

public class FireNotificationRemoteAssembler {
	public static FireNotificationIDTO toRemote(FireNotificationDTO dto) {

		FireNotificationIDTO idto = new FireNotificationIDTO().withActionName(dto.getType())
				.withAddress(dto.getAddress()).withCity(dto.getCity()).withCreator(dto.getCreator())
				.withDescription(dto.getDescription()).withLatitude(safeDoubleToString(dto.getGpsXCoordinate()))
				.withLongitude(safeDoubleToString(dto.getGpsYCoordinate()))
				.withNotifiactionDate(dto.getNotificationDate()).withType(dto.getType());

		// FIXME:
		idto.withRequestedFirefightersUnitNumber(1);
		List<OrderedResource> orderedResources = new ArrayList<>();
		idto.withOrderedResources(orderedResources);

		return idto;
	}

	private static String safeDoubleToString(Double d) {
		if (d == null) {
			return StringUtils.EMPTY;
		}
		return d.toString();
	}
}
