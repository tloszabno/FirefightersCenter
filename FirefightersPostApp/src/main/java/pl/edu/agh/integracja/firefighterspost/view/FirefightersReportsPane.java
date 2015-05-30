package pl.edu.agh.integracja.firefighterspost.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import pl.edu.agh.integracja.firefighterspost.gui.model.*;
import pl.edu.agh.integracja.firefighterspost.service.ReportsService;

import javax.annotation.Resource;
import java.util.Arrays;

public class FirefightersReportsPane {

  private static final int COLUMNS_NUMBER = 2;
  final ObservableList<ReportHeaderGuiModel> data = FXCollections.observableArrayList();
  private final TableView<ReportHeaderGuiModel> table = new TableView<>();
  private Button getReportsListBtn;
  private Button getReportDetailsBtn;
  private GridPane grid;

  @Resource(name = "reportsService")
  private ReportsService reportsService;

  public GridPane initView() {
    initRootGridPane();
    initMainAppHeader();
    initReportsTable();
    initBottomButtons();

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
    Text scenetitle = new Text("Post Firefighters - raporty");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    scenetitle.setId("welcome-text");
    grid.add(scenetitle, 0, 0, COLUMNS_NUMBER, 1);
  }

  private void initReportsTable() {
    table.setEditable(true);

    TableColumn typeColumn = new TableColumn("Data Powiadomienia");
    typeColumn.setMinWidth(160);
    typeColumn.setCellValueFactory(
        new PropertyValueFactory<>("notificationDate"));

    TableColumn cityColumn = new TableColumn("Nazwa");
    cityColumn.setMinWidth(100);
    cityColumn.setCellValueFactory(
        new PropertyValueFactory<>("actionName"));

    TableColumn shortDescriptionColumn = new TableColumn("Adres");
    shortDescriptionColumn.setMinWidth(200);
    shortDescriptionColumn.setCellValueFactory(
        new PropertyValueFactory<>("address"));

    table.setItems(data);
    table.getColumns().addAll(typeColumn, cityColumn, shortDescriptionColumn);

    grid.add(table, 0, 1, COLUMNS_NUMBER, 1);

  }

  private void initBottomButtons() {
    getReportsListBtn = new Button("Pobierz listę raportów");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
    hbBtn.getChildren().add(getReportsListBtn);
    grid.add(hbBtn, 0, 2, 1, 1);

    getReportsListBtn.setOnAction(event -> {
      data.addAll(reportsService.getReportsList());
//      data.addAll(Arrays.asList(
//          new ReportHeaderGuiModel("1", "2015-05-23 12:45:13", "pożar 1", "Kraków, Bieżanowska 12")
//      ));

//      notificationsService.confirmAlert(table.getSelectionModel().getSelectedItem().getExternalId());
//      statusText.setFill(Color.FIREBRICK);
//      statusText.setText("Wysłano potwierdzonie otrzymania alarmu.");
//      alarmReceivedLbl.setText("");
    });

    getReportDetailsBtn = new Button("Pobierz szczegóły raportu");
    hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
    hbBtn.getChildren().add(getReportDetailsBtn);
    grid.add(hbBtn, 1, 2, 1, 1);

    getReportDetailsBtn.setOnAction(event -> {

      ReportPane reportPane = new ReportPane();
      GridPane reportsPane = reportPane.initView(ReportPane.ReportPaneMode.VIEW_REPORT);
      reportPane.fillWithData(new ReportGuiModel()
              .setAccidentType("Pożar")
              .setActtionName("Pożar samochodu na ul. Bieżanowskiej")
              .setAreaSize("5m2")
              .setCommunity("Kraków")
              .setCreator("kpt. Jan Kowalski")
              .setObjectName("Samochód fiat Punto")
              .setOwner("ZIKiT")
              .setPostName("OSP Bieżanów")
              .setBrigades(Arrays.asList(
                  new ReportBrigadeGuiModel()
                      .setName("1 zastęp")
                      .setPumpWorkTime("40 minut")
                      .setMembersNumber("4")
                      .setDistance("3 km")
                      .setArrivalTime("2015-05-23T12:34:45")
                      .setDepartureTime("2015-05-23T11:34:45")))
              .setFirefighters(Arrays.asList(
                  new ReportFirefighterGuiModel()
                      .setName("Jan")
                      .setSurname("Kowalski"),
                  new ReportFirefighterGuiModel()
                      .setName("Maciej")
                      .setSurname("Kowalski"),
                  new ReportFirefighterGuiModel()
                      .setName("Janusz")
                      .setSurname("Kowalski"),
                  new ReportFirefighterGuiModel()
                      .setName("Igor")
                      .setSurname("Kowalski")))
              .setDamages(Arrays.asList(
                  new ReportDamageGuiModel()
                      .setDescription("Przebita opona"),
                  new ReportDamageGuiModel()
                      .setDescription("Uszkodzona pompa paliwa")))
              .setUsedEquipment(Arrays.asList(
                  new ReportEquipmentGuiModel()
                      .setName("Wóz bojowy nr 4")
                      .setFuelType("Beznyna")
                      .setWorkTime("1 godzina"),
                  new ReportEquipmentGuiModel()
                      .setName("Gaśnica")
                      .setWorkTime("20 min")
                      .setFuelType("-"),
                  new ReportEquipmentGuiModel()
                      .setName("Piasek neutralizujący olej")
                      .setFuelType("-")
                      .setWorkTime("-")))

      );
      new ReportWindow().initStage(reportsPane).show();
//      stage.show();
//      notificationsService.confirmAlert(table.getSelectionModel().getSelectedItem().getExternalId());
//      statusText.setFill(Color.FIREBRICK);
//      statusText.setText("Wysłano potwierdzonie otrzymania alarmu.");
//      alarmReceivedLbl.setText("");
    });

  }

}
