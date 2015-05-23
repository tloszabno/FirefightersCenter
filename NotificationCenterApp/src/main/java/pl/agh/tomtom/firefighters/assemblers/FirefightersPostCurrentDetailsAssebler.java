package pl.agh.tomtom.firefighters.assemblers;

import generated.integracja.common.dto.AvailableEquipment;
import generated.integracja.common.dto.CurrentStateIDTO;

import java.util.List;
import java.util.stream.Collectors;

import pl.agh.tomtom.firefighters.dto.FirefightersPostCurrentDetailsDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.dto.PostEquipmentInfo;

public class FirefightersPostCurrentDetailsAssebler {
	public static FirefightersPostCurrentDetailsDTO fromRemote(CurrentStateIDTO idto,
			FirefightersPostDTO firefightersPostDTO) {

		List<AvailableEquipment> availableEquipment = idto.getAvailableEquipment();
		Integer availableUnits = idto.getAvailableUnits();

		FirefightersPostCurrentDetailsDTO dto = new FirefightersPostCurrentDetailsDTO();
		List<PostEquipmentInfo> equipmentInfoDTOs = availableEquipment.stream().map(s -> convertEquipment(s))
				.collect(Collectors.toList());
		dto.setAvailable(availableUnits != null && availableUnits > 0).setAvailableUnits(availableUnits)
				.setFirefightersPost(firefightersPostDTO).setEquipmentInfo(equipmentInfoDTOs);

		return dto;
	}

	private static PostEquipmentInfo convertEquipment(AvailableEquipment idto) {
		PostEquipmentInfo dto = new PostEquipmentInfo();
		dto.setCount(idto.getQuantity());
		dto.setEquipmentName(idto.getName());
		return dto;
	}
}
