package pl.edu.agh.integracja.firefighterspost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.integracja.firefighterspost.dao.AlertDao;
import pl.edu.agh.integracja.firefighterspost.dao.CurrentStateDao;
import pl.edu.agh.integracja.firefighterspost.handler.GetCurrentStateHandler;
import pl.edu.agh.integracja.firefighterspost.handler.PostFireNotificationHandler;
import pl.edu.agh.integracja.firefighterspost.translator.AlertTranslator;
import pl.edu.agh.integracja.firefighterspost.translator.CurrentStateTranslator;
import pl.edu.agh.integracja.firefighterspost.view.MainAppPane;

@Configuration
public class Config {

  @Bean(name = "getCurrentStateHandler")
  public GetCurrentStateHandler getCurrentStateHandler() {
    return new GetCurrentStateHandler();
  }

  @Bean(name = "currentStateDao")
  public CurrentStateDao currentStateDao() {
    return new CurrentStateDao();
  }

  @Bean(name = "currentStateTranslator")
  public CurrentStateTranslator currentStateTranslator() {
    return new CurrentStateTranslator();
  }

  @Bean(name = "postFireNotificationHandler")
  public PostFireNotificationHandler postFireNotificationHandler() {
    PostFireNotificationHandler postFireNotificationHandler = new PostFireNotificationHandler();
    postFireNotificationHandler.addAlertHandler(mainAppPane());
    return postFireNotificationHandler;
  }

  @Bean(name = "alertDao")
  public AlertDao alertDao() {
    return new AlertDao();
  }

  @Bean(name = "alertTranslator")
  public AlertTranslator alertTranslator() {
    return new AlertTranslator();
  }

  @Bean(name = "mainAppPane")
  public MainAppPane mainAppPane() {
    return new MainAppPane();
  }

}
