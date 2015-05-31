package pl.agh.tomtom.firefighters.services;

import java.util.List;

import pl.agh.tomtom.firefighters.dto.ReportDTO;
import pl.agh.tomtom.firefighters.exceptions.FireException;

public interface ReportService {
	List<ReportDTO> getAllReports();

	ReportDTO getReport(Long id) throws FireException;

	List<ReportDTO> getReportsForNotification(Long notificationId);

	void saveReport(ReportDTO report) throws FireException;
}
