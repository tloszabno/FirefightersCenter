package pl.edu.agh.integracja.firefighterspost.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
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
    Scene scene = new Scene(root, 900, 700, Color.WHITE);

    pane.prefHeightProperty().bind(scene.heightProperty());
    pane.prefWidthProperty().bind(scene.widthProperty());

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setContent(pane);
    root.getChildren().add(scrollPane);

    stage.setScene(scene);
    return stage;
  }
}
