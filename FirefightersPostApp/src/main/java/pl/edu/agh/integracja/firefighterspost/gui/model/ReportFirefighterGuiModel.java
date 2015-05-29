package pl.edu.agh.integracja.firefighterspost.gui.model;

public class ReportFirefighterGuiModel {

  private String name;
  private String surname;

  public String getName() {
    return name;
  }

  public ReportFirefighterGuiModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getSurname() {
    return surname;
  }

  public ReportFirefighterGuiModel setSurname(String surname) {
    this.surname = surname;
    return this;
  }
}
