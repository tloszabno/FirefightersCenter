package pl.agh.tomtom.firefighters.dto;

public class EquipmentReportEntryDTO {
	private Long id;

	private String equipmentType;

	private Double workTimeH;

	private String fuelType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public Double getWorkTimeH() {
		return workTimeH;
	}

	public void setWorkTimeH(Double workTimeH) {
		this.workTimeH = workTimeH;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

}
