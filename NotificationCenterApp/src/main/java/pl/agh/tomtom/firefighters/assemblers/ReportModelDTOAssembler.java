package pl.agh.tomtom.firefighters.assemblers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import pl.agh.tomtom.firefighters.dto.EquipmentReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FireNotificationDTO;
import pl.agh.tomtom.firefighters.dto.FirefighterReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersBrigadeReportEntryDTO;
import pl.agh.tomtom.firefighters.dto.FirefightersPostDTO;
import pl.agh.tomtom.firefighters.dto.ReportDTO;
import pl.agh.tomtom.firefighters.model.EquipmentReportEntry;
import pl.agh.tomtom.firefighters.model.ExtinguishingStuffReportEntry;
import pl.agh.tomtom.firefighters.model.FirefighterReportEntry;
import pl.agh.tomtom.firefighters.model.FirefightersBrigadeReportEntry;
import pl.agh.tomtom.firefighters.model.Report;
import pl.agh.tomtom.firefighters.utils.AuthUtils;

public class ReportModelDTOAssembler {

	public static ReportDTO fromModel(Report model) {

		ReportDTO dto = new ReportDTO();
		dto.setCreator(model.getCreator());
		dto.setCommunity(model.getCommunity());
		dto.setId(model.getId());
		dto.setNotificationType(model.getNotificationType());
		dto.setObject(model.getObject());
		dto.setOtherDamage(model.getOtherDamage());
		dto.setOwner(model.getOwner());
		dto.setSize(model.getSize());

		List<EquipmentReportEntryDTO> equipmentDTOs = model.getEquipment().stream()
				.map(s -> equipmentFromModelToDTO(s)).collect(Collectors.toList());
		dto.setEquipment(equipmentDTOs);

		List<FirefightersBrigadeReportEntryDTO> firefightersBrigadesDTOs = model.getFirefightersBrigades().stream()
				.map(s -> firefightersBrigadeFromModelToDTO(s)).collect(Collectors.toList());
		dto.setFirefightersBrigades(firefightersBrigadesDTOs);

		FirefightersPostDTO firefightersPostDTO = FirefightersPostAssembler.fromModel(model.getFirefightersPost());
		dto.setFirefightersPost(firefightersPostDTO);

		List<FirefighterReportEntryDTO> firemansDTOs = model.getFiremans().stream()
				.map(s -> firefightersFromModelToDTO(s)).collect(Collectors.toList());
		dto.setFiremans(firemansDTOs);

		FireNotificationDTO fireNotificationDTO = FireNotificationAssembler.fromModel(model.getFireNotification());
		dto.setFireNotification(fireNotificationDTO);

		return dto;
	}

	private static EquipmentReportEntryDTO equipmentFromModelToDTO(EquipmentReportEntry model) {
		EquipmentReportEntryDTO dto = new EquipmentReportEntryDTO();
		dto.setEquipmentType(model.getEquipmentType());
		dto.setFuelType(model.getFuelType());
		dto.setId(model.getId());
		dto.setWorkTimeH(model.getWorkTimeH());
		return dto;
	}

	private static FirefightersBrigadeReportEntryDTO firefightersBrigadeFromModelToDTO(
			FirefightersBrigadeReportEntry model) {
		FirefightersBrigadeReportEntryDTO dto = new FirefightersBrigadeReportEntryDTO();
		dto.setArrivalTime(model.getArrivalTime());
		dto.setDepartureTime(model.getDepartureTime());
		dto.setDistanceKM(model.getDistanceKM());
		dto.setId(model.getId());
		dto.setMemberNumber(model.getMemberNumber());
		dto.setName(model.getName());
		dto.setPumpWorktime(model.getPumpWorktime());
		dto.setTankSource("Hydrant"); // FIXME
		return dto;
	}

	private static FirefighterReportEntryDTO firefightersFromModelToDTO(FirefighterReportEntry model) {
		FirefighterReportEntryDTO dto = new FirefighterReportEntryDTO();
		dto.setFirstName(model.getFirstName());
		dto.setId(model.getId());
		dto.setSurname(model.getSurname());
		return dto;
	}

	/**
	 * Converts dto to model <br/>
	 * Not fills FirefightersPost and FireNotification !
	 *
	 * @param dto
	 * @return
	 */
	public static Report fromDTO(ReportDTO dto) {
		Report model = new Report();
		model.setCommunity(dto.getCommunity());
		model.setCreator(StringUtils.isNotEmpty(dto.getCreator()) ? dto.getCreator() : AuthUtils.getUserLogin());
		model.setId(dto.getId());
		model.setNotificationType(dto.getNotificationType());
		model.setObject(dto.getObject());
		model.setOtherDamage(dto.getOtherDamage());
		model.setOwner(dto.getOwner());
		model.setSize(dto.getSize());
		List<EquipmentReportEntry> equipmentModel = dto.getEquipment().stream().map(e -> equipmentFromDTOToModel(e))
				.collect(Collectors.toList());
		model.setEquipment(equipmentModel);

		List<FirefightersBrigadeReportEntry> firefightersBrigadesModel = dto.getFirefightersBrigades().stream()
				.map(f -> firefightersBrigadeFromDTOToModel(f)).collect(Collectors.toList());
		model.setFirefightersBrigades(firefightersBrigadesModel);

		List<FirefighterReportEntry> firemansModel = dto.getFiremans().stream().map(f -> firefightersFromDTOToModel(f))
				.collect(Collectors.toList());
		model.setFiremans(firemansModel);
		return model;
	}

	private static EquipmentReportEntry equipmentFromDTOToModel(EquipmentReportEntryDTO dto) {
		EquipmentReportEntry model = new EquipmentReportEntry();
		model.setEquipmentType(dto.getEquipmentType());
		model.setFuelType(dto.getFuelType());
		model.setWorkTimeH(dto.getWorkTimeH());
		return model;
	}

	private static FirefightersBrigadeReportEntry firefightersBrigadeFromDTOToModel(
			FirefightersBrigadeReportEntryDTO dto) {
		FirefightersBrigadeReportEntry model = new FirefightersBrigadeReportEntry();
		model.setArrivalTime(dto.getArrivalTime());
		model.setDepartureTime(dto.getDepartureTime());
		model.setDistanceKM(dto.getDistanceKM());
		model.setExtinguishingStuffReportEntries(new ArrayList<ExtinguishingStuffReportEntry>());// FIXME
		model.setMemberNumber(dto.getMemberNumber());
		model.setName(dto.getName());
		model.setPumpWorktime(dto.getPumpWorktime());
		return model;
	}

	private static FirefighterReportEntry firefightersFromDTOToModel(FirefighterReportEntryDTO dto) {
		FirefighterReportEntry model = new FirefighterReportEntry();
		model.setFirstName(dto.getFirstName());
		model.setSurname(dto.getSurname());
		return model;
	}
}
