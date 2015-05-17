package pl.agh.tomtom.firefighters.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FirefightersBrigadeReportEntryDTO {
	private Long id;
	private String name;

	private Integer memberNumber;

	private Integer distanceKM;

	private Date departureTime;

	private Date arrivalTime;

	private Integer pumpWorktime;

	private String tankSource;

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

	public FirefightersBrigadeReportEntryDTO setTankSource(String tankSource) {
		this.tankSource = tankSource;
		return this;
	}

	public String getTankSource() {
		return tankSource;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}