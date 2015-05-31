package pl.agh.tomtom.firefighters.assemblers;

import generated.integracja.common.dto.*;
import org.apache.commons.lang3.StringUtils;
import pl.agh.tomtom.firefighters.dto.*;

import java.util.Arrays;
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

  public static ReportIDTO toIDTOModel(ReportDTO reportDTO) {
    return new ReportIDTO()
        .withCommunity(reportDTO.getCommunity())
        .withCreator(reportDTO.getCreator())
        .withNotificationId(reportDTO.getFireNotification().getId().toString())
        .withObjectName(reportDTO.getObject())
        .withOwner(reportDTO.getOwner())
        .withAreaSize(reportDTO.getSize())
        .withPostName(reportDTO.getFirefightersPost().getName())
        .withActionName(reportDTO.getFireNotification().getType())
        .withActionName(reportDTO.getNotificationType())
        .withOtherDamages(Arrays.asList(StringUtils.split(reportDTO.getOtherDamage(), ","))
            .stream()
            .map(string -> new OtherDamage()
                .withDamageName(string.trim()))
            .collect(Collectors.toList()))
        .withUsedEquipment(
            reportDTO.getEquipment().stream()
                .map(eq -> new UsedEquipment()
                    .withName(eq.getEquipmentType())
                    .withFuelType(eq.getFuelType())
                    .withWorkTimeInH(eq.getWorkTimeH().intValue()))
                .collect(Collectors.toList())
        )
        .withFirefighters(reportDTO.getFiremans().stream()
            .map(fm ->
                    new Firefighter()
                        .withName(fm.getFirstName())
                        .withSurname(fm.getSurname())
            ).collect(Collectors.toList()))
        .withBrigades(reportDTO.getFirefightersBrigades().stream()
            .map(brigade -> new Brigade()
                    .withName(brigade.getName())
                    .withDistanceInKm(brigade.getDistanceKM())
                    .withMembersNumber(brigade.getMemberNumber())
                    .withPumpworkTime(brigade.getPumpWorktime().toString())
                    .withArrivalTime(brigade.getArrivalTime())
                    .withDepartureTime(brigade.getDepartureTime())
            )
            .collect(Collectors.toList()));

  }
}
