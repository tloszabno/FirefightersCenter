package pl.agh.tomtom.firefighters.assemblers;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.model.FireNotification;
import pl.agh.tomtom.firefighters.model.FirefightersPost;
import pl.agh.tomtom.firefighters.utils.AuthUtils;

public class FireNotificationAssembler {

	public static void fillModelWithDTO(FireNotification model,//
			FireNotificationDTO dto) {

		List<FirefightersPost> posts = Collections.emptyList();

		model.setActionState(dto.getActionState())//
				.setAddress(dto.getAddress())//
				.setCity(dto.getCity())
				//
				.setCreator(dto.getCreator() == null ? AuthUtils.getUserLogin() : dto.getCreator())//
				.setDescription(dto.getDescription())//
				.setFinishDate(dto.getFinishDate())//
				.setFirefightersPosts(posts)//
				.setGpsXCoordinate(dto.getGpsXCoordinate())//
				.setGpsYCoordinate(dto.getGpsYCoordinate())//
				.setNotificationDate(dto.getNotificationDate() == null ? new Date() : dto.getNotificationDate())//
				.setType(dto.getType());
	}

	public static FireNotificationDTO fromModel(FireNotification model) {
		FireNotificationDTO dto = new FireNotificationDTO();
		dto.setActionState(model.getActionState())//
				.setAddress(model.getAddress()) //
				.setCity(model.getCity())//
				.setCreator(model.getCreator())//
				.setDescription(model.getDescription()) //
				.setFinishDate(model.getFinishDate())//
				.setGpsXCoordinate(model.getGpsXCoordinate())//
				.setGpsYCoordinate(model.getGpsYCoordinate())//
				.setId(model.getId())//
				.setNotificationDate(model.getNotificationDate())//
				.setType(model.getType());

		List<FirefightersPostDTO> posts = model.getFirefightersPosts().stream()
				.map(p -> FirefightersPostAssembler.fromModel(p)).collect(Collectors.toList());
		dto.setFirefightersPosts(posts);

		return dto;
	}
}
