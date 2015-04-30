package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "equipment_report_entry")
public class EquipmentReportEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "equipment_type", nullable = false, length = 300)
	private String equipmentType;

	@Column(name = "work_time_h", nullable = true)
	private Double workTimeH;

	@Column(name = "fuel_type", nullable = false, length = 300)
	private String fuelType;

	public EquipmentReportEntry() {
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
