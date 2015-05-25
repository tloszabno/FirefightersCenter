package pl.edu.agh.integracja.firefighterspost;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.agh.integracja.firefighterspost.view.FirefightersAlertsPane;
import pl.edu.agh.integracja.firefighterspost.view.FirefightersReportsPane;
import pl.edu.agh.integracja.firefighterspost.view.FirefightersRootPane;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Tabs");

//    Group root = new Group();
//    Scene scene = new Scene(root, 550, 550, Color.WHITE);
//    TabPane tabPane = new TabPane();
//    BorderPane borderPane = new BorderPane();
//
//    GridPane alertsPane = new FirefightersAlertsPane().initView();
//    Tab tabAlerts = new Tab();
//    tabAlerts.setClosable(false);
//    tabAlerts.setText("Powiadomienia");
//    tabAlerts.setContent(alertsPane);
//    tabPane.getTabs().add(tabAlerts);
//
//    GridPane reportsPane = new FirefightersAlertsPane().initView();
//    Tab tabReports = new Tab();
//    tabReports.setClosable(false);
//    tabReports.setText("Raporty");
//    tabReports.setContent(reportsPane);
//    tabPane.getTabs().add(tabReports);
//
//    borderPane.prefHeightProperty().bind(scene.heightProperty());
//    borderPane.prefWidthProperty().bind(scene.widthProperty());
//
//    borderPane.setCenter(tabPane);
//    root.getChildren().add(borderPane);

    stage.setScene(new FirefightersRootPane(new FirefightersAlertsPane(), new FirefightersReportsPane()).initScene());
    stage.show();
  }
}
