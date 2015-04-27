package pl.edu.agh.integracja.firefighterspost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.integracja.firefighterspost.service.AlertService;
import pl.edu.agh.integracja.firefighterspost.view.MainAppPane;

@Configuration
public class Config {

    @Bean(name = "alertService")
    public AlertService alertService() {
        return new AlertService();
    }

    @Bean(name = "mainAppPane")
    public MainAppPane mainAppPane() {
        return new MainAppPane();
    }
}
