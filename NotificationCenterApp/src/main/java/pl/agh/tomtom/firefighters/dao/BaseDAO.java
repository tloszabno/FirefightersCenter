package pl.agh.tomtom.firefighters.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class BaseDAO<BEAN extends Serializable, ID extends Serializable> extends HibernateDaoSupport {

	private static final Logger log = LogManager.getLogger();

	private Class<BEAN> classOfBEAN;

	public BaseDAO(Class<BEAN> classOfBEAN) {
		this.classOfBEAN = classOfBEAN;
	}

	public List<BEAN> list() {
		log.entry();

		@SuppressWarnings("unchecked")
		List<BEAN> result = (List<BEAN>) getHibernateTemplate().find("from " + classOfBEAN.getName());

		log.exit(result);
		return result;
	}

	public void save(BEAN bean) {
		log.entry(bean);

		getHibernateTemplate().save(bean);

		log.exit();
	}

	public void saveOrUpdate(BEAN bean) {
		log.entry(bean);

		getHibernateTemplate().saveOrUpdate(bean);

		log.exit();
	}

	public BEAN get(ID id) {
		log.entry(id);

		BEAN result = getHibernateTemplate().get(classOfBEAN, id);

		log.exit(result);
		return result;
	}

}
