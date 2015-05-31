package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.*;
import pl.edu.agh.integracja.firefighterspost.dateutils.GuiDateCOnverter;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportGuiModel;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportHeaderGuiModel;

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
}
