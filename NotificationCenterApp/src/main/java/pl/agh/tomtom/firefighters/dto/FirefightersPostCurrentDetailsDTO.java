package pl.agh.tomtom.firefighters.dto;

import java.util.Collections;
import java.util.List;

public class FirefightersPostCurrentDetailsDTO {
	private FirefightersPostDTO firefightersPost;
	private boolean available = false;
	private Integer availableUnits;
	private List<PostEquipmentInfo> equipmentInfo = Collections.emptyList();

	public FirefightersPostCurrentDetailsDTO setAvailable(boolean available) {
		this.available = available;
		return this;
	}

	public FirefightersPostCurrentDetailsDTO setAvailableUnits(Integer availableUnits) {
		this.availableUnits = availableUnits;
		return this;
	}

	public FirefightersPostCurrentDetailsDTO setFirefightersPost(FirefightersPostDTO firefightersPost) {
		this.firefightersPost = firefightersPost;
		return this;
	}

	public Integer getAvailableUnits() {
		return availableUnits;
	}

	public FirefightersPostDTO getFirefightersPost() {
		return firefightersPost;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setEquipmentInfo(List<PostEquipmentInfo> equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	public List<PostEquipmentInfo> getEquipmentInfo() {
		return equipmentInfo;
	}

}
