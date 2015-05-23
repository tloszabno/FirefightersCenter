package pl.edu.agh.integracja.firefighterspost.db.dto;

import javax.persistence.*;

@Entity
@Table(name = "ORDERED_RESOURCES")
public class OrderedResourceDbDto {

  private Long id;
  private String name;
  private Integer quantity;

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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
