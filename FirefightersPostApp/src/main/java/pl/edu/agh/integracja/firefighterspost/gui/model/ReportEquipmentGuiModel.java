package pl.edu.agh.integracja.firefighterspost.gui.model;

public class ReportEquipmentGuiModel {
  private String name;
  private String workTime;
  private String fuelType;

  public String getName() {
    return name;
  }

  public ReportEquipmentGuiModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getWorkTime() {
    return workTime;
  }

  public ReportEquipmentGuiModel setWorkTime(String workTime) {
    this.workTime = workTime;
    return this;
  }

  public String getFuelType() {
    return fuelType;
  }

  public ReportEquipmentGuiModel setFuelType(String fuelType) {
    this.fuelType = fuelType;
    return this;
  }
}
