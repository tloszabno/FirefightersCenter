package pl.edu.agh.integracja.firefighterspost.gui.model;

public class ReportBrigadeGuiModel {

  private String name;
  private String membersNumber;
  private String distance;
  private String departureTime;
  private String arrivalTime;
  private String pumpWorkTime;

  public String getName() {
    return name;
  }

  public ReportBrigadeGuiModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getMembersNumber() {
    return membersNumber;
  }

  public ReportBrigadeGuiModel setMembersNumber(String membersNumber) {
    this.membersNumber = membersNumber;
    return this;
  }

  public String getDistance() {
    return distance;
  }

  public ReportBrigadeGuiModel setDistance(String distance) {
    this.distance = distance;
    return this;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public ReportBrigadeGuiModel setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public ReportBrigadeGuiModel setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  public String getPumpWorkTime() {
    return pumpWorkTime;
  }

  public ReportBrigadeGuiModel setPumpWorkTime(String pumpWorkTime) {
    this.pumpWorkTime = pumpWorkTime;
    return this;
  }
}
