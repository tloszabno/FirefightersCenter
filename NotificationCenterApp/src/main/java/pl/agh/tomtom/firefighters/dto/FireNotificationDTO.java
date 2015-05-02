package pl.agh.tomtom.firefighters.dto;

import java.util.Date;

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

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getGpsXCoordinate() {
		return gpsXCoordinate;
	}

	public void setGpsXCoordinate(Double gpsXCoordinate) {
		this.gpsXCoordinate = gpsXCoordinate;
	}

	public Double getGpsYCoordinate() {
		return gpsYCoordinate;
	}

	public void setGpsYCoordinate(Double gpsYCoordinate) {
		this.gpsYCoordinate = gpsYCoordinate;
	}

	public String getActionState() {
		return actionState;
	}

	public void setActionState(String actionState) {
		this.actionState = actionState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
