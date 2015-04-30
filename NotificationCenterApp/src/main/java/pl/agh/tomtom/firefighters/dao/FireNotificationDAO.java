package pl.agh.tomtom.firefighters.dao;

import pl.agh.tomtom.firefighters.model.FireNotification;

public class FireNotificationDAO extends BaseDAO<FireNotification, Long> {

	public FireNotificationDAO() {
		super(FireNotification.class);
	}

}
