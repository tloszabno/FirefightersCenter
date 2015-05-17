package pl.edu.agh.integracja.firefighterspost.rest.dto;

public class AlertNotificationRestDto {

  private String date;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "AlertNotificationRestDto{" +
        "date='" + date + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
