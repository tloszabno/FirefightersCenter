package pl.edu.agh.integracja.firefighterspost.translator;

import pl.edu.agh.integracja.common.dto.FireNotificationIDTO;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;
import pl.edu.agh.integracja.firefighterspost.db.dto.OrderedResourceDbDto;
import pl.edu.agh.integracja.firefighterspost.gui.model.AlertGuiModel;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class AlertTranslator {

  public AlertNotificationDbDto fromRestToDbModel(FireNotificationIDTO restDto) {
    AlertNotificationDbDto dbDto = new AlertNotificationDbDto();
    dbDto.setActionName(restDto.getActionName());
    dbDto.setAddress(restDto.getAddress());
    dbDto.setCity(restDto.getCity());
    dbDto.setCreator(restDto.getCreator());
    dbDto.setDescription(restDto.getDescription());
    dbDto.setExternalId(restDto.getNotificationId());
    dbDto.setLatitude(restDto.getLatitude());
    dbDto.setLongitude(restDto.getLongitude());
    dbDto.setNotifiactionDate(restDto.getNotifiactionDate());
    dbDto.setRequestedFirefightersUnitNumber(restDto.getRequestedFirefightersUnitNumber());
    dbDto.setType(restDto.getType());
    dbDto.setOrderedResources(restDto.getOrderedResources().stream().map(rest ->
    {
      OrderedResourceDbDto orderedResourceDbDto = new OrderedResourceDbDto();
      orderedResourceDbDto.setName(rest.getName());
      orderedResourceDbDto.setQuantity(rest.getQuantity());
      return orderedResourceDbDto;
    }).collect(Collectors.toList()));

    return dbDto;

  }

  public AlertGuiModel fromDbToGuiModel(AlertNotificationDbDto dbModel) {
    AlertGuiModel guiModel = new AlertGuiModel();
    guiModel.setExternalId(dbModel.getExternalId());
    guiModel.setType(dbModel.getType());
    guiModel.setAddress(dbModel.getAddress());
    guiModel.setCity(dbModel.getCity());
    guiModel.setActionName(dbModel.getActionName());
    guiModel.setDescription(dbModel.getDescription());
    guiModel.setLatitude(dbModel.getLatitude());
    guiModel.setLongitude(dbModel.getLongitude());
    guiModel.setNotifiactionDate(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(dbModel.getNotifiactionDate()));
    guiModel.setCreator(dbModel.getCreator());
    guiModel.setRequestedUnits(dbModel.getRequestedFirefightersUnitNumber().toString());
    guiModel.setOrderedResources(dbModel.getOrderedResources().stream().map(or -> or.getName() + ": " + or.getQuantity()).collect(Collectors.toList()));
    guiModel.setRequestedFirefightersUnitNumber(dbModel.getRequestedFirefightersUnitNumber());

    return guiModel;
  }
}
