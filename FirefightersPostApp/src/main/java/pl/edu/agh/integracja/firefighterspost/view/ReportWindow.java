package pl.edu.agh.integracja.firefighterspost.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ReportWindow {

  public Stage initStage(GridPane pane) {
    Stage stage = new Stage();
    stage.initModality(Modality.WINDOW_MODAL);
    stage.setTitle("Raport");

    Group root = new Group();
    Scene scene = new Scene(root, 550, 550, Color.WHITE);
    TabPane tabPane = new TabPane();

    pane.prefHeightProperty().bind(scene.heightProperty());
    pane.prefWidthProperty().bind(scene.widthProperty());

    root.getChildren().add(pane);

    stage.setScene(scene);
    return stage;
  }
}
