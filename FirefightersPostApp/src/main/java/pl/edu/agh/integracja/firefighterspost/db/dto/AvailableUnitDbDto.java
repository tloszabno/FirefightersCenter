package pl.edu.agh.integracja.firefighterspost.db.dto;

import javax.persistence.*;

@Entity
@Table(name = "UNITS")
public class AvailableUnitDbDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public AvailableUnitDbDto() {
  }

  public AvailableUnitDbDto(Long id) {
    this.id = id;
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
}
