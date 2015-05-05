package pl.agh.tomtom.firefighters.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FireNotificationDTO {

	private Long id;

	private String type;

	private String address;

	private String city;

	private Double gpsXCoordinate;

	private Double gpsYCoordinate;

	private String actionState;

	private String description;

	private Date notificationDate;

	private Date finishDate;

	private String creator;

	public Long getId() {
		return id;
	}

	public FireNotificationDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public FireNotificationDTO setType(String type) {
		this.type = type;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public FireNotificationDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public FireNotificationDTO setCity(String city) {
		this.city = city;
		return this;
	}

	public Double getGpsXCoordinate() {
		return gpsXCoordinate;
	}

	public FireNotificationDTO setGpsXCoordinate(Double gpsXCoordinate) {
		this.gpsXCoordinate = gpsXCoordinate;
		return this;
	}

	public Double getGpsYCoordinate() {
		return gpsYCoordinate;
	}

	public FireNotificationDTO setGpsYCoordinate(Double gpsYCoordinate) {
		this.gpsYCoordinate = gpsYCoordinate;
		return this;
	}

	public String getActionState() {
		return actionState;
	}

	public FireNotificationDTO setActionState(String actionState) {
		this.actionState = actionState;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FireNotificationDTO setDescription(String description) {
		this.description = description;
		return this;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public FireNotificationDTO setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
		return this;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public FireNotificationDTO setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public FireNotificationDTO setCreator(String creator) {
		this.creator = creator;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
