package pl.agh.tomtom.firefighters.dto;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FireNotificationReportDTO {
	private FireNotificationDTO notification;
	private List<ReportDTO> reports = new LinkedList<ReportDTO>();

	public FireNotificationDTO getNotification() {
		return notification;
	}

	public void setNotification(FireNotificationDTO notificationDTO) {
		this.notification = notificationDTO;
	}

	public List<ReportDTO> getReports() {
		return reports;
	}

	public void setReports(List<ReportDTO> reports) {
		this.reports = reports;
	}

	public FireNotificationReportDTO addReport(ReportDTO report) {
		this.reports.add(report);
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
