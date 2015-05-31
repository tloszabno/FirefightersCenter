package pl.agh.tomtom.firefighters.dao;

import pl.agh.tomtom.firefighters.model.FirefightersPost;

import java.util.List;

public class FirefightersPostDAO extends BaseDAO<FirefightersPost, Long> {

	public FirefightersPostDAO() {
		super(FirefightersPost.class);
	}

	public List<FirefightersPost> getByName(String name){
		return (List<FirefightersPost>) getHibernateTemplate().find("from FirefightersPost where name = ?", name);
	}

}
