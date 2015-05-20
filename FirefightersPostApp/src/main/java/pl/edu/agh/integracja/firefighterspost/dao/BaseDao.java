package pl.edu.agh.integracja.firefighterspost.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

class BaseDao {
  @Autowired
  SessionFactory sessionFactory;

  protected Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }
}
