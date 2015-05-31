package pl.agh.tomtom.firefighters.assemblers;

import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.model.FirefightersPost;

public class FirefightersPostAssembler {
	public static void fillModelWithDTO(FirefightersPost model, FirefightersPostDTO dto) {
		model.setAddress(dto.getAddress()) //
				.setCity(dto.getCity())//
				.setCommunity(dto.getCommunity())//
				.setName(dto.getName())//
				.setSystemIpAddress(dto.getSystemIpAddress());

	}

	public static FirefightersPostDTO fromModel(FirefightersPost model) {
		FirefightersPostDTO dto = new FirefightersPostDTO();
		if (model != null) {
			dto.setAddress(model.getAddress())//
					.setCity(model.getCity())//
					.setCommunity(model.getCommunity())//
					.setId(model.getId())//
					.setName(model.getName())//
					.setSystemIpAddress(model.getSystemIpAddress());
		}
		return dto;
	}
}
