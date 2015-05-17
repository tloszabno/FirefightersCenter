package pl.agh.tomtom.firefighters.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class PostEquipmentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String equipmentName = StringUtils.EMPTY;

	private int count = 0;

	public String getEquipmentName() {
		return equipmentName;
	}

	public PostEquipmentInfo setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
		return this;
	}

	public int getCount() {
		return count;
	}

	public PostEquipmentInfo setCount(int count) {
		this.count = count;
		return this;
	}

}
