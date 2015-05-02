package pl.agh.tomtom.firefighters.dto;

import java.util.List;

public class ReportDTO {
	private Long id;

	private FireNotificationDTO fireNotification;

	private FirefightersPostDTO firefightersPost;

	private String notificationType;

	private String community;

	private Double size;

	private String object;

	private String owner;

	private String otherDamage;

	private String creator;

	private List<EquipmentReportEntryDTO> equipment;

	private List<FirefighterReportEntryDTO> firemans;

	private List<FirefightersBrigadeReportEntryDTO> firefightersBrigades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FireNotificationDTO getFireNotification() {
		return fireNotification;
	}

	public void setFireNotification(FireNotificationDTO fireNotification) {
		this.fireNotification = fireNotification;
	}

	public FirefightersPostDTO getFirefightersPost() {
		return firefightersPost;
	}

	public void setFirefightersPost(FirefightersPostDTO firefightersPost) {
		this.firefightersPost = firefightersPost;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOtherDamage() {
		return otherDamage;
	}

	public void setOtherDamage(String otherDamage) {
		this.otherDamage = otherDamage;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public List<EquipmentReportEntryDTO> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<EquipmentReportEntryDTO> equipment) {
		this.equipment = equipment;
	}

	public List<FirefighterReportEntryDTO> getFiremans() {
		return firemans;
	}

	public void setFiremans(List<FirefighterReportEntryDTO> firemans) {
		this.firemans = firemans;
	}

	public List<FirefightersBrigadeReportEntryDTO> getFirefightersBrigades() {
		return firefightersBrigades;
	}

	public void setFirefightersBrigades(
			List<FirefightersBrigadeReportEntryDTO> firefightersBrigades) {
		this.firefightersBrigades = firefightersBrigades;
	}

}
