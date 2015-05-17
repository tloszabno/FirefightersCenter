package pl.edu.agh.integracja.firefighterspost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.integracja.firefighterspost.dao.AlertDao;
import pl.edu.agh.integracja.firefighterspost.service.AlertService;
import pl.edu.agh.integracja.firefighterspost.translator.AlertTranslator;
import pl.edu.agh.integracja.firefighterspost.view.MainAppPane;

@Configuration
public class Config {

  @Bean(name = "alertService")
  public AlertService alertService() {
    AlertService alertService = new AlertService();
    return alertService;
  }

  @Bean(name = "mainAppPane")
  public MainAppPane mainAppPane() {
    return new MainAppPane();
  }

  @Bean(name = "alertDao")
  public AlertDao alertDao() {
    return new AlertDao();
  }

  @Bean(name = "alertTranslator")
  public AlertTranslator alertTranslator() {
    return new AlertTranslator();
  }

}
