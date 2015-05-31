package pl.agh.tomtom.firefighters.assemblers;

import generated.integracja.common.dto.ReportIDTO;
import org.apache.commons.lang3.StringUtils;
import pl.agh.tomtom.firefighters.dto.*;

import java.util.stream.Collectors;

public class ReportIDTOAssembler {

  public static ReportDTO fromIDTOModel(ReportIDTO idtoModel) {

    ReportDTO reportDTO = new ReportDTO();
    reportDTO.setCommunity(idtoModel.getCommunity());
    reportDTO.setCreator(idtoModel.getCreator());
    reportDTO.setFireNotification(new FireNotificationDTO().setId(Long.parseLong(idtoModel.getNotificationId())));
    reportDTO.setNotificationType(idtoModel.getAccidentType());
    reportDTO.setObject(idtoModel.getObjectName());
    reportDTO.setOwner(idtoModel.getOwner());
    reportDTO.setSize(idtoModel.getAreaSize());

    reportDTO.setOtherDamage(StringUtils.join(
        idtoModel.getOtherDamages().stream()
            .map(dam -> dam.getDamageName())
            .collect(Collectors.toList())
        , ", "));

    reportDTO.setEquipment(
        idtoModel.getUsedEquipment().stream()
            .map(equipment ->
                new EquipmentReportEntryDTO()
                    .setFuelType(equipment.getFuelType())
                    .setEquipmentType(equipment.getName())
                    .setWorkTimeH(equipment.getWorkTimeInH().doubleValue()))
            .collect(Collectors.toList()));

    reportDTO.setFiremans(idtoModel.getFirefighters().stream()
        .map(fireman ->
                new FirefighterReportEntryDTO()
                    .setFirstName(fireman.getName())
                    .setSurname(fireman.getSurname())
        ).collect(Collectors.toList()));

    reportDTO.setFirefightersBrigades(idtoModel.getBrigades().stream()
        .map(brigade ->
                new FirefightersBrigadeReportEntryDTO()
                    .setName(brigade.getName())
                    .setDistanceKM(brigade.getDistanceInKm())
                    .setMemberNumber(brigade.getMembersNumber())
                    .setTankSource("Orlen")
                    .setPumpWorktime(Integer.parseInt(brigade.getPumpworkTime()))
                    .setArrivalTime(brigade.getArrivalTime())
                    .setDepartureTime(brigade.getDepartureTime())
        ).collect(Collectors.toList()));

    return reportDTO;
  }
}
