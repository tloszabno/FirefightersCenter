package pl.edu.agh.integracja.firefighterspost.db.dto;

import javax.persistence.*;

@Entity
@Table(name = "ALERTS")
public class AlertNotificationDbDto {

  private Long id;
  private String name;

  public AlertNotificationDbDto() {
  }

  public AlertNotificationDbDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
