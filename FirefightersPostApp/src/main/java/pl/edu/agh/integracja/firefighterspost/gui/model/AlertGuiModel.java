package pl.edu.agh.integracja.firefighterspost.gui.model;

import javafx.beans.property.SimpleStringProperty;

public class AlertGuiModel {

  private SimpleStringProperty type;
  private SimpleStringProperty address = new SimpleStringProperty("Bieżanowska 24");
  private SimpleStringProperty city;
  private SimpleStringProperty actionName;
  private SimpleStringProperty requestedUnits;

  public AlertGuiModel(String type, String city, String actionName, String requestedUnits) {
    this.type = new SimpleStringProperty(type);
    this.city = new SimpleStringProperty(city);
    this.actionName = new SimpleStringProperty(actionName);
    this.requestedUnits = new SimpleStringProperty(requestedUnits);
  }

  public String getType() {
    return type.get();
  }

  public void setType(String type) {
    this.type.set(type);
  }

  public SimpleStringProperty typeProperty() {
    return type;
  }

  public String getAddress() {
    return address.get();
  }

  public void setAddress(String address) {
    this.address.set(address);
  }

  public SimpleStringProperty addressProperty() {
    return address;
  }

  public String getCity() {
    return city.get();
  }

  public void setCity(String city) {
    this.city.set(city);
  }

  public SimpleStringProperty cityProperty() {
    return city;
  }

  public String getActionName() {
    return actionName.get();
  }

  public void setActionName(String actionName) {
    this.actionName.set(actionName);
  }

  public SimpleStringProperty actionNameProperty() {
    return actionName;
  }

  public String getRequestedUnits() {
    return requestedUnits.get();
  }

  public void setRequestedUnits(String requestedUnits) {
    this.requestedUnits.set(requestedUnits);
  }

  public SimpleStringProperty requestedUnitsProperty() {
    return requestedUnits;
  }

  @Override
  public String toString() {
    return
        "type=" + type.getValue() +
        "\naddress=" + address.getValue() +
        "\ncity=" + city.getValue() +
        "\nactionName=" + actionName.getValue() +
        "\nrequestedUnits=" + requestedUnits.getValue() +
        '}';
  }
}
