package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.*;
import pl.edu.agh.integracja.firefighterspost.dateutils.GuiDateCOnverter;
import pl.edu.agh.integracja.firefighterspost.gui.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class ReportsTranslator {

  public List<ReportHeaderGuiModel> translateListFromRestToGui(ReportListIDTO reportsList) {
    return reportsList.getReportHeaders().stream()
        .map(rest -> new ReportHeaderGuiModel(rest.getReportId(), rest.getNotificationDate(), rest.getActionName(), rest.getAddress()))
        .collect(Collectors.toList());
  }

  public ReportIDTO translateReportFromGuiToRest(ReportGuiModel reportGuiModel) {

    return new ReportIDTO()
        .withAccidentType(reportGuiModel.getAccidentType())
        .withActionName(reportGuiModel.getActtionName())
        .withAreaSize(reportGuiModel.getAreaSize())
        .withCommunity(reportGuiModel.getCommunity())
        .withCreator(reportGuiModel.getCreator())
        .withNotificationId(reportGuiModel.getNotificationId())
        .withObjectName(reportGuiModel.getObjectName())
        .withOwner(reportGuiModel.getOwner())
        .withPostName(reportGuiModel.getPostName())
        .withBrigades(reportGuiModel.getBrigades().stream()
            .map(gui -> new Brigade()
                    .withName(gui.getName())
                    .withArrivalTime(GuiDateCOnverter.fromStringToDate(gui.getArrivalTime()))
                    .withDepartureTime(GuiDateCOnverter.fromStringToDate(gui.getDepartureTime()))
                    .withDistanceInKm(Integer.parseInt(gui.getDistance()))
                    .withMembersNumber(Integer.parseInt(gui.getMembersNumber()))
                    .withPumpworkTime(gui.getPumpWorkTime())
            ).collect(Collectors.toList()))
        .withFirefighters(reportGuiModel.getFirefighters().stream()
                .map(gui -> new Firefighter()
                        .withName(gui.getName())
                        .withSurname(gui.getSurname())
                )
                .collect(Collectors.toList())
        ).withOtherDamages(reportGuiModel.getDamages().stream().map(gui -> new OtherDamage()
                .withDamageName(gui.getDescription()))

                .collect(Collectors.toList())
        ).withUsedEquipment(reportGuiModel.getUsedEquipment().stream()
            .map(gui -> new UsedEquipment()
                    .withName(gui.getName())
                    .withFuelType(gui.getFuelType())
                    .withWorkTimeInH(Integer.parseInt(gui.getWorkTime()))

            ).collect(Collectors.toList()));
  }

  public ReportGuiModel translateReportFromRestToGui(ReportIDTO reportIDTO) {
    return new ReportGuiModel()
        .setNotificationId(reportIDTO.getNotificationId())
        .setAreaSize(reportIDTO.getAreaSize())
        .setAccidentType(reportIDTO.getAccidentType())
        .setActtionName(reportIDTO.getActionName())
        .setCommunity(reportIDTO.getCommunity())
        .setCreator(reportIDTO.getCreator())
        .setObjectName(reportIDTO.getObjectName())
        .setOwner(reportIDTO.getOwner())
        .setPostName(reportIDTO.getPostName())
        .setBrigades(reportIDTO.getBrigades().stream().map(rest ->
                new ReportBrigadeGuiModel()
                    .setArrivalTime(GuiDateCOnverter.fromDateToGuiShortDisplay(rest.getArrivalTime()))
                    .setDepartureTime(GuiDateCOnverter.fromDateToGuiShortDisplay(rest.getDepartureTime()))
                    .setDistance(rest.getDistanceInKm().toString())
                    .setMembersNumber(rest.getMembersNumber().toString())
                    .setName(rest.getName())
                    .setPumpWorkTime(rest.getPumpworkTime())
        ).collect(Collectors.toList()))
        .setFirefighters(reportIDTO.getFirefighters().stream().map(rest ->
                new ReportFirefighterGuiModel()
                    .setName(rest.getName())
                    .setSurname(rest.getSurname())
        ).collect(Collectors.toList()))
        .setDamages(reportIDTO.getOtherDamages().stream().map(rest ->
                new ReportDamageGuiModel()
                    .setDescription(rest.getDamageName())
        ).collect(Collectors.toList()))
        .setUsedEquipment(reportIDTO.getUsedEquipment().stream().map(rest ->
                new ReportEquipmentGuiModel()
                    .setName(rest.getName())
                    .setFuelType(rest.getFuelType())
                    .setWorkTime(rest.getWorkTimeInH().toString())
        ).collect(Collectors.toList()));
  }
}
