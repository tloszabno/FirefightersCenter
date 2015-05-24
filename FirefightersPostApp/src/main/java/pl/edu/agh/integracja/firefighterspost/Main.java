package pl.edu.agh.integracja.firefighterspost;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.edu.agh.integracja.firefighterspost.view.FirefightersMainPane;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    GridPane mainPane = new FirefightersMainPane().initView();
    Scene scene = new Scene(mainPane, 500, 500, Color.BLACK);
    stage.setTitle("JavaFX Scene Graph Demo");
    stage.setScene(scene);
    stage.show();
  }
}
