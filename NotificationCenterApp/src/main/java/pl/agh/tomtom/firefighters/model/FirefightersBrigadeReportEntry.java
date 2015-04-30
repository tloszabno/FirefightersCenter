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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "firefighters_brigadeReport_entry")
public class FirefightersBrigadeReportEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", length = 500, nullable = false)
	private String name;

	@Column(name = "member_number", nullable = false)
	private Integer memberNumber;

	@Column(name = "distance_km", nullable = true)
	private Integer distanceKM;

	@Column(name = "departure_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;

	@Column(name = "arrival_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;

	@Column(name = "pump_worktime", nullable = true)
	private Integer pumpWorktime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_extinguishing_stuff")
	private List<ExtinguishingStuffReportEntry> extinguishingStuffReportEntries;

	public FirefightersBrigadeReportEntry() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public Integer getDistanceKM() {
		return distanceKM;
	}

	public void setDistanceKM(Integer distanceKM) {
		this.distanceKM = distanceKM;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getPumpWorktime() {
		return pumpWorktime;
	}

	public void setPumpWorktime(Integer pumpWorktime) {
		this.pumpWorktime = pumpWorktime;
	}

	public List<ExtinguishingStuffReportEntry> getExtinguishingStuffReportEntries() {
		return extinguishingStuffReportEntries;
	}

	public void setExtinguishingStuffReportEntries(
			List<ExtinguishingStuffReportEntry> extinguishingStuffReportEntries) {
		this.extinguishingStuffReportEntries = extinguishingStuffReportEntries;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
