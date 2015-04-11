package pl.agh.tomtom.firefighters.dao;

import pl.agh.tomtom.firefighters.model.Zgloszenie;

public class ZgloszenieDAO extends BaseDAO<Zgloszenie, Long> {

	public ZgloszenieDAO() {
		super(Zgloszenie.class);
	}

}
