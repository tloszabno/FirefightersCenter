package pl.edu.agh.integracja.firefighterspost.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import pl.edu.agh.integracja.firefighterspost.gui.model.AlertGuiModel;
import pl.edu.agh.integracja.firefighterspost.service.NotificationsService;

import javax.annotation.Resource;

public class FirefightersMainPane implements AlertListener<AlertGuiModel> {

  private static final int GRID_HEADER_IDX = 0;
  private static final int GRID_NOTIFICATION_IDX = 1;
  private static final int GRID_ALERTS_TABLE_IDX = 2;
  private static final int GRID_DESCRIPTION_IDX = 3;
  private static final int GRID_BUTTONS_IDX = 4;
  private static final int GRID_BOTTOM_STATUS_IDX = 5;
  private static final int GRID_COLUMN_NUMBERS = 3;
  final ObservableList<AlertGuiModel> data = FXCollections.observableArrayList(
      new AlertGuiModel("Pożar", "Kraków", "Pożar samochodu", "2"),
      new AlertGuiModel("Pożar", "Wieliczka", "Pożar domu", "5")
  );
  private final TableView<AlertGuiModel> table = new TableView<>();
  @Resource(name = "notificationsService")
  private NotificationsService notificationsService;
  private Label alarmReceivedLbl;
  private Button confirmAlertBtn;
  private Button finishAlertBtn;
  private Button reportAlertBtn;
  private Text descriptionText;
  private Text statusText;
  private GridPane grid;

  public GridPane initView() {
    initRootGridPane();
    initMainAppHeader();
    initNotificationPlaceholder();
    initAlertTable();
    initAlertDescriptionPlaceholder();
    initBottomButtons();
    initBottomStateText();

    return grid;
  }

  private void initRootGridPane() {
    grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
  }

  private void initMainAppHeader() {
    Text scenetitle = new Text("Post Firefighters");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    scenetitle.setId("welcome-text");
    grid.add(scenetitle, 0, GRID_HEADER_IDX, GRID_COLUMN_NUMBERS, 1);
  }

  private void initNotificationPlaceholder() {
    alarmReceivedLbl = new Label("");
    grid.add(alarmReceivedLbl, 0, GRID_NOTIFICATION_IDX, GRID_COLUMN_NUMBERS, 1);
  }

  private void initAlertTable() {

    table.setEditable(true);

    TableColumn typeColumn = new TableColumn("Typ");
    typeColumn.setMinWidth(100);
    typeColumn.setCellValueFactory(
        new PropertyValueFactory<>("Type"));

    TableColumn cityColumn = new TableColumn("Miejscowość");
    cityColumn.setMinWidth(100);
    cityColumn.setCellValueFactory(
        new PropertyValueFactory<>("city"));

    TableColumn shortDescriptionColumn = new TableColumn("Krótki opis");
    shortDescriptionColumn.setMinWidth(200);
    shortDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<>("actionName"));

    TableColumn unitsNumber = new TableColumn("Zastępy");
    unitsNumber.setMinWidth(40);
    unitsNumber.setCellValueFactory(
        new PropertyValueFactory<>("units"));

    table.setItems(data);
    table.getColumns().addAll(typeColumn, cityColumn, shortDescriptionColumn, unitsNumber);

    table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        descriptionText.setText(table.getSelectionModel().getSelectedItem().toString());
      }
    });

    grid.add(table, 0, GRID_ALERTS_TABLE_IDX, GRID_COLUMN_NUMBERS, 1);

  }

  private void initAlertDescriptionPlaceholder() {
    descriptionText = new Text();
    grid.add(descriptionText, 0, GRID_DESCRIPTION_IDX, GRID_COLUMN_NUMBERS, 1);
  }

  private void initBottomButtons() {
    confirmAlertBtn = new Button("Potwierdź otrzymanie");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
    hbBtn.getChildren().add(confirmAlertBtn);
    grid.add(hbBtn, 0, GRID_BUTTONS_IDX, 1, 1);

    confirmAlertBtn.setOnAction(event -> {
      statusText.setFill(Color.FIREBRICK);
      statusText.setText("Wysłano potwierdzonie otrzymania alarmu.");
      alarmReceivedLbl.setText("");
    });

    finishAlertBtn = new Button("Zakończona");
    hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
    hbBtn.getChildren().add(finishAlertBtn);
    grid.add(hbBtn, 1, GRID_BUTTONS_IDX, 1, 1);

    finishAlertBtn.setOnAction(event -> {
      statusText.setFill(Color.FIREBRICK);
      statusText.setText("Wysłąno potwierdzenie zakończenia akcji.");
      alarmReceivedLbl.setText("");
    });

    reportAlertBtn = new Button("Raport");
    hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
    hbBtn.getChildren().add(reportAlertBtn);
    grid.add(hbBtn, 2, GRID_BUTTONS_IDX, 1, 1);

    reportAlertBtn.setOnAction(event -> {
      statusText.setFill(Color.FIREBRICK);
      statusText.setText("Wysłano raport.");
      alarmReceivedLbl.setText("");
    });
  }

  private void initBottomStateText() {
    statusText = new Text();
    statusText.setId("confirmationTxt");
    grid.add(statusText, 0, GRID_BOTTOM_STATUS_IDX, GRID_COLUMN_NUMBERS, 1);
  }

  @Override
  public void onAlertReceive(AlertGuiModel message) {
    Platform.runLater(() -> {
      data.add(0, message);
    });
  }
}
