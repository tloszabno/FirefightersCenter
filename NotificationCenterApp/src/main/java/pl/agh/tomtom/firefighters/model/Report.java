package pl.agh.tomtom.firefighters.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fire_notification_id")
	private FireNotification fireNotification;

	@ManyToOne
	@JoinColumn(name = "firefighters_post_id")
	private FirefightersPost firefightersPost;

	@Column(name = "notification_type", length = 300, nullable = false)
	private String notificationType;

	@Column(name = "community", length = 300, nullable = false)
	private String community;

	@Column(name = "size", nullable = true)
	private String size;

	@Column(name = "object", length = 500, nullable = true)
	private String object;

	@Column(name = "owner", length = 500, nullable = true)
	private String owner;

	@Column(name = "other_damage", length = 1000, nullable = true)
	private String otherDamage;

	@Column(name = "creator", length = 300, nullable = false)
	private String creator;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")
	private List<EquipmentReportEntry> equipment;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")
	private List<FirefighterReportEntry> firemans;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")
	private List<FirefightersBrigadeReportEntry> firefightersBrigades;

	public Report() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FireNotification getFireNotification() {
		return fireNotification;
	}

	public void setFireNotification(FireNotification fireNotification) {
		this.fireNotification = fireNotification;
	}

	public FirefightersPost getFirefightersPost() {
		return firefightersPost;
	}

	public void setFirefightersPost(FirefightersPost firefightersPost) {
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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

	public List<EquipmentReportEntry> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<EquipmentReportEntry> equipment) {
		this.equipment = equipment;
	}

	public List<FirefighterReportEntry> getFiremans() {
		return firemans;
	}

	public void setFiremans(List<FirefighterReportEntry> firemans) {
		this.firemans = firemans;
	}

	public List<FirefightersBrigadeReportEntry> getFirefightersBrigades() {
		return firefightersBrigades;
	}

	public void setFirefightersBrigades(List<FirefightersBrigadeReportEntry> firefightersBrigades) {
		this.firefightersBrigades = firefightersBrigades;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
