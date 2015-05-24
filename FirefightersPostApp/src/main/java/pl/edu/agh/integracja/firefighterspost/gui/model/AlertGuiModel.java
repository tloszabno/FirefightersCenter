package pl.edu.agh.integracja.firefighterspost.gui.model;

import java.util.ArrayList;
import java.util.List;

public class AlertGuiModel {

  private Long externalId;
  private String type;
  private String address;
  private String city;
  private String actionName;
  private String description;
  private String latitude;
  private String longitude;
  private String notifiactionDate;
  private String creator;
  private String requestedUnits;
  private List<String> orderedResources = new ArrayList<>();
  private Integer requestedFirefightersUnitNumber;

  public Long getExternalId() {
    return externalId;
  }

  public void setExternalId(Long externalId) {
    this.externalId = externalId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getNotifiactionDate() {
    return notifiactionDate;
  }

  public void setNotifiactionDate(String notifiactionDate) {
    this.notifiactionDate = notifiactionDate;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getRequestedUnits() {
    return requestedUnits;
  }

  public void setRequestedUnits(String requestedUnits) {
    this.requestedUnits = requestedUnits;
  }

  public List<String> getOrderedResources() {
    return orderedResources;
  }

  public void setOrderedResources(List<String> orderedResources) {
    this.orderedResources = orderedResources;
  }

  public Integer getRequestedFirefightersUnitNumber() {
    return requestedFirefightersUnitNumber;
  }

  public void setRequestedFirefightersUnitNumber(Integer requestedFirefightersUnitNumber) {
    this.requestedFirefightersUnitNumber = requestedFirefightersUnitNumber;
  }

  @Override
  public String toString() {
    return
        "Typ: " + type + '\'' +
        "\nAdres: " + address + '\'' +
        "\nMiasto: " + city + '\'' +
        "\nKrótki opis: '" + actionName + '\'' +
        "\nOpis: " + description + '\'' +
        "\nLokalizacja-szerokość: " + latitude + '\'' +
        "\nLokalizacja-długość: " + longitude + '\'' +
        "\nData powiadomienia: " + notifiactionDate + '\'' +
        "\nZgłaszający: " + creator + '\'' +
        "\nLiczba zastępów: " + requestedUnits + '\'' +
        "\nZamówiony sprzęt: " + orderedResources +
        "\nLiczba zamówionych zastępów: " + requestedFirefightersUnitNumber;
  }
}
