package pl.agh.tomtom.firefighters.dao;

import pl.agh.tomtom.firefighters.model.Report;

public class ReportDAO extends BaseDAO<Report, Long> {

	public ReportDAO() {
		super(Report.class);
	}

}
