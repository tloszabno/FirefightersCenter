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
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportHeaderGuiModel;

import java.util.Arrays;

public class FirefightersReportsPane {

  private static final int COLUMNS_NUMBER = 2;
  final ObservableList<ReportHeaderGuiModel> data = FXCollections.observableArrayList();
  private final TableView<ReportHeaderGuiModel> table = new TableView<>();
  private Button getReportsListBtn;
  private Button getReportDetailsBtn;
  private GridPane grid;

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
      data.addAll(Arrays.asList(
          new ReportHeaderGuiModel("1", "2015-05-23 12:45:13", "pożar 1", "Kraków, Bieżanowska 12")
      ));

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

//      notificationsService.confirmAlert(table.getSelectionModel().getSelectedItem().getExternalId());
//      statusText.setFill(Color.FIREBRICK);
//      statusText.setText("Wysłano potwierdzonie otrzymania alarmu.");
//      alarmReceivedLbl.setText("");
    });

  }

}
