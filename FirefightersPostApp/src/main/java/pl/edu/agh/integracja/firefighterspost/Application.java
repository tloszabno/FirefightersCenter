package pl.edu.agh.integracja.firefighterspost;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import pl.edu.agh.integracja.firefighterspost.controller.PostController;
import pl.edu.agh.integracja.firefighterspost.view.AppView;

public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        LOG.info("Starting App");
        SpringApplication.run(PostController.class, args);
        AppView.main(args);
        LOG.info("Application started");
    }
}
