package pl.edu.agh.integracja.firefighterspost.db.dto;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENTS")
public class EquipmentDbDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer quantity;

  public EquipmentDbDto() {
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
