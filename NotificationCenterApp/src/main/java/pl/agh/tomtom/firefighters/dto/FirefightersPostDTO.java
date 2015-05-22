package pl.agh.tomtom.firefighters.dto;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FirefightersPostDTO {
	private Long id;

	private String name;

	private String address;

	private String city;

	private String community;

	private String systemIpAddress;

	private boolean confirmation = true;

	// used only for gui
	@Deprecated
	private boolean canDelete = false;

	private List<PostEquipmentInfo> equipmentInfo = Collections.emptyList();

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Long getId() {
		return id;
	}

	public FirefightersPostDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public FirefightersPostDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public FirefightersPostDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public FirefightersPostDTO setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCommunity() {
		return community;
	}

	public FirefightersPostDTO setCommunity(String community) {
		this.community = community;
		return this;
	}

	public String getSystemIpAddress() {
		return systemIpAddress;
	}

	public FirefightersPostDTO setSystemIpAddress(String systemIpAddress) {
		this.systemIpAddress = systemIpAddress;
		return this;
	}

	public void setEquipmentInfo(List<PostEquipmentInfo> equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	public List<PostEquipmentInfo> getEquipmentInfo() {
		return equipmentInfo;
	}

	@Deprecated
	public boolean isCanDelete() {
		return canDelete;
	}

	@Deprecated
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
