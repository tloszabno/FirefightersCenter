package pl.agh.tomtom.firefighters.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EquipmentReportEntryDTO {
	private Long id;

	private String equipmentType;

	private Double workTimeH;

	private String fuelType;

	public Long getId() {
		return id;
	}

	public EquipmentReportEntryDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public EquipmentReportEntryDTO setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
		return this;
	}

	public Double getWorkTimeH() {
		return workTimeH;
	}

	public EquipmentReportEntryDTO setWorkTimeH(Double workTimeH) {
		this.workTimeH = workTimeH;
		return this;
	}

	public String getFuelType() {
		return fuelType;
	}

	public EquipmentReportEntryDTO setFuelType(String fuelType) {
		this.fuelType = fuelType;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
