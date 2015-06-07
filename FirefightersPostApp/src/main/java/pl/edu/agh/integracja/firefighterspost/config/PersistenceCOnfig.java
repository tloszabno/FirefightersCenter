package pl.edu.agh.integracja.firefighterspost.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sqlite.SQLiteDataSource;
import pl.edu.agh.integracja.firefighterspost.db.dto.AlertNotificationDbDto;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    SQLiteDataSource dataSource = new SQLiteDataSource();
    dataSource.setUrl("jdbc:sqlite:test.db");
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setPackagesToScan(new String[]{AlertNotificationDbDto.class.getPackage().getName()});
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);

    return txManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  private Properties hibernateProperties() {
    return new Properties() {
      {
        setProperty("hibernate.hbm2ddl.auto", "create");
        setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
        setProperty("hibernate.globally_quoted_identifiers", "true");
        setProperty("hibernate.show_sql", "true");
        setProperty("hibernate.format_sql", "true");
      }
    };
  }
}
