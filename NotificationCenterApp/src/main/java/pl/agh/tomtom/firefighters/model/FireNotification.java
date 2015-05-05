package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Table(name = "fire_notification")
@Entity
public class FireNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "type", length = 200, nullable = false)
	private String type;

	@Column(name = "address", length = 300, nullable = false)
	private String address;

	@Column(name = "city", length = 300, nullable = false)
	private String city;

	@Column(name = "gps_x_coordinate", nullable = true)
	private Double gpsXCoordinate;

	@Column(name = "gps_y_coordinate", nullable = true)
	private Double gpsYCoordinate;

	@Column(name = "action_state", length = 1000, nullable = true)
	private String actionState;

	@Column(name = "description", length = 3000, nullable = true)
	private String description;

	@Column(name = "notification_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationDate;

	@Column(name = "finish_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;

	@Column(name = "creator", length = 200, nullable = false)
	private String creator;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "firefighters_posts")
	private List<FirefightersPost> firefightersPosts;

	public FireNotification() {
	}

	public FireNotification(String typ, String adres, String miasto,
			String autor) {
		super();
		this.type = typ;
		this.address = adres;
		this.city = miasto;
		this.creator = autor;
		this.notificationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public FireNotification setId(Long id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public FireNotification setType(String type) {
		this.type = type;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public FireNotification setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCity() {
		return city;
	}

	public FireNotification setCity(String city) {
		this.city = city;
		return this;
	}

	public Double getGpsXCoordinate() {
		return gpsXCoordinate;
	}

	public FireNotification setGpsXCoordinate(Double gpsXCoordinate) {
		this.gpsXCoordinate = gpsXCoordinate;
		return this;
	}

	public Double getGpsYCoordinate() {
		return gpsYCoordinate;
	}

	public FireNotification setGpsYCoordinate(Double gpsYCoordinate) {
		this.gpsYCoordinate = gpsYCoordinate;
		return this;
	}

	public String getActionState() {
		return actionState;
	}

	public FireNotification setActionState(String actionState) {
		this.actionState = actionState;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FireNotification setDescription(String description) {
		this.description = description;
		return this;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public FireNotification setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
		return this;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public FireNotification setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public FireNotification setCreator(String creator) {
		this.creator = creator;
		return this;
	}

	public List<FirefightersPost> getFirefightersPosts() {
		return firefightersPosts;
	}

	public FireNotification setFirefightersPosts(
			List<FirefightersPost> firefightersPosts) {
		this.firefightersPosts = firefightersPosts;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
