package pl.edu.agh.integracja.firefighterspost;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import pl.edu.agh.integracja.firefighterspost.dao.DummyDataProvider;
import pl.edu.agh.integracja.firefighterspost.view.FirefightersRootPane;

import javax.annotation.Resource;
import java.net.URL;

@Lazy
@SpringBootApplication
public class FirefighterPostApp extends Application {

  private static final Logger LOG = Logger.getLogger(FirefighterPostApp.class);
  private static String[] savedArgs;

  @Resource(name = "firefightersRootPane")
  private FirefightersRootPane firefightersRootPane;

  @Resource(name = "dummyDataProvider")
  private DummyDataProvider dummyDataProvider;

  private ConfigurableApplicationContext applicationContext;

  protected static void launchApp(Class<? extends Application> appClass, String[] args) {
    savedArgs = args;
    Application.launch(appClass, args);
  }

  public static void main(String[] args) {
    launchApp(FirefighterPostApp.class, args);
  }

  @Override
  public void init() throws Exception {
    applicationContext = SpringApplication.run(getClass(), savedArgs);
    applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    dummyDataProvider.storeDummyPostResources();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    applicationContext.close();
  }

  @Override
  public void start(Stage stage) throws Exception {
    notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
    stage.setTitle("Post Firefighters App");
    Scene scene = firefightersRootPane.initScene();
    stage.setScene(scene);

    URL resource = FirefighterPostApp.class.getClassLoader().getResource("ui.css");
    scene.getStylesheets().add(resource.toExternalForm());

    stage.setResizable(true);
    stage.centerOnScreen();
    stage.show();
    LOG.info("Application Started");
  }

}
