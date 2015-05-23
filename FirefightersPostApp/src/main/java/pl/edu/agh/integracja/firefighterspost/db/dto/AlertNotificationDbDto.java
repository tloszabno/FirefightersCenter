package pl.edu.agh.integracja.firefighterspost.db.dto;

import pl.edu.agh.integracja.common.dto.OrderedResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ALERTS")
public class AlertNotificationDbDto {

  private Long internalId;

  private Long externalId;
  private String type;
  private String address;
  private String city;
  private String actionName;
  private String description;
  private String latitude;
  private String longitude;
  private Date notifiactionDate;
  private String creator;
  private List<OrderedResourceDbDto> orderedResources = new ArrayList<>();
  private Integer requestedFirefightersUnitNumber;

  public AlertNotificationDbDto() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getInternalId() {
    return internalId;
  }

  public void setInternalId(Long internalId) {
    this.internalId = internalId;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String name) {
    this.actionName = name;
  }

  public Long getExternalId() {
    return externalId;
  }

  public void setExternalId(Long externalId) {
    this.externalId = externalId;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Date getNotifiactionDate() {
    return notifiactionDate;
  }

  public void setNotifiactionDate(Date notifiactionDate) {
    this.notifiactionDate = notifiactionDate;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Integer getRequestedFirefightersUnitNumber() {
    return requestedFirefightersUnitNumber;
  }

  public void setRequestedFirefightersUnitNumber(Integer requestedFirefightersUnitNumber) {
    this.requestedFirefightersUnitNumber = requestedFirefightersUnitNumber;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<OrderedResourceDbDto> getOrderedResources() {
    return orderedResources;
  }

  public void setOrderedResources(List<OrderedResourceDbDto> orderedResources) {
    this.orderedResources = orderedResources;
  }
}
