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

  public void setReportId(String reportId) {
    this.reportId = reportId;
  }

  public String getNotificationDate() {
    return notificationDate;
  }

  public void setNotificationDate(String notificationDate) {
    this.notificationDate = notificationDate;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
