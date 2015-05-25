package pl.edu.agh.integracja.firefighterspost.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FirefightersRootPane {


  private FirefightersAlertsPane firefightersAlertsPane;
  private FirefightersReportsPane firefightersReportsPane;

  public FirefightersRootPane(FirefightersAlertsPane firefightersAlertsPane, FirefightersReportsPane firefightersReportsPane) {
    this.firefightersAlertsPane = firefightersAlertsPane;
    this.firefightersReportsPane = firefightersReportsPane;
  }

  public Scene initScene() {
    Group root = new Group();
    Scene scene = new Scene(root, 550, 550, Color.WHITE);
    TabPane tabPane = new TabPane();
    BorderPane borderPane = new BorderPane();

    Tab tabAlerts = new Tab();
    tabAlerts.setClosable(false);
    tabAlerts.setText("Powiadomienia");
    tabAlerts.setContent(firefightersAlertsPane.initView());
    tabPane.getTabs().add(tabAlerts);

    GridPane reportsPane = firefightersReportsPane.initView();
    Tab tabReports = new Tab();
    tabReports.setClosable(false);
    tabReports.setText("Raporty");
    tabReports.setContent(reportsPane);
    tabPane.getTabs().add(tabReports);

    borderPane.prefHeightProperty().bind(scene.heightProperty());
    borderPane.prefWidthProperty().bind(scene.widthProperty());

    borderPane.setCenter(tabPane);
    root.getChildren().add(borderPane);
    return scene;
  }

}
