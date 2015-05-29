package pl.edu.agh.integracja.firefighterspost.gui.model;

public class ReportHeaderGuiModel {

  private String reportId;
  private String notificationDate;
  private String actionName;
  private String address;

  public ReportHeaderGuiModel(String reportId, String notificationDate, String actionName, String address) {
    this.reportId = reportId;
    this.notificationDate = notificationDate;
    this.actionName = actionName;
    this.address = address;
  }

  public String getReportId() {
    return reportId;
  }

  public ReportHeaderGuiModel setReportId(String reportId) {
    this.reportId = reportId;
    return this;
  }

  public String getNotificationDate() {
    return notificationDate;
  }

  public ReportHeaderGuiModel setNotificationDate(String notificationDate) {
    this.notificationDate = notificationDate;
    return this;
  }

  public String getActionName() {
    return actionName;
  }

  public ReportHeaderGuiModel setActionName(String actionName) {
    this.actionName = actionName;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public ReportHeaderGuiModel setAddress(String address) {
    this.address = address;
    return this;
  }
}
