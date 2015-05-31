package pl.agh.tomtom.firefighters.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

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

  public FirefightersBrigadeReportEntryDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public FirefightersBrigadeReportEntryDTO setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getMemberNumber() {
    return memberNumber;
  }

  public FirefightersBrigadeReportEntryDTO setMemberNumber(Integer memberNumber) {
    this.memberNumber = memberNumber;
    return this;
  }

  public Integer getDistanceKM() {
    return distanceKM;
  }

  public FirefightersBrigadeReportEntryDTO setDistanceKM(Integer distanceKM) {
    this.distanceKM = distanceKM;
    return this;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public FirefightersBrigadeReportEntryDTO setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public FirefightersBrigadeReportEntryDTO setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  public Integer getPumpWorktime() {
    return pumpWorktime;
  }

  public FirefightersBrigadeReportEntryDTO setPumpWorktime(Integer pumpWorktime) {
    this.pumpWorktime = pumpWorktime;
    return this;
  }

  public String getTankSource() {
    return tankSource;
  }

  public FirefightersBrigadeReportEntryDTO setTankSource(String tankSource) {
    this.tankSource = tankSource;
    return this;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
