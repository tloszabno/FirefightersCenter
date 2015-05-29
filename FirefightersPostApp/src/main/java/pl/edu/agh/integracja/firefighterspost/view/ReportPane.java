package pl.edu.agh.integracja.firefighterspost.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportBrigadeGuiModel;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportDamageGuiModel;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportEquipmentGuiModel;
import pl.edu.agh.integracja.firefighterspost.gui.model.ReportFirefighterGuiModel;

public class ReportPane {

  private static final int COLUMNS_NUMBER = 2;
  private static final int LABEL_IDX = 0;
  private static final int TEXT_IDX = 1;
  final ObservableList<ReportDamageGuiModel> damagesList = FXCollections.observableArrayList();
  final ObservableList<ReportEquipmentGuiModel> equipmentsList = FXCollections.observableArrayList();
  final ObservableList<ReportFirefighterGuiModel> firefightersList = FXCollections.observableArrayList();
  final ObservableList<ReportBrigadeGuiModel> brigadesList = FXCollections.observableArrayList();
  private GridPane grid;
  private TextField postNameText;
  private TextField actionNameText;
  private TextField accidentTypeText;
  private TextField communityText;
  private TextField areaSizeText;
  private TextField objectNameText;
  private TextField objectOwnerText;
  private TextField otherDamagesText;
  private TextField reporterText;
  private TextField usedEquipmentText;
  private TextField firefightersText;
  private TextField brigadesText;
  private TableView<ReportDamageGuiModel> damagesTable;
  private TableView<ReportEquipmentGuiModel> equipmentTable;
  private TableView<ReportFirefighterGuiModel> firefightersTable;
  private TableView<ReportBrigadeGuiModel> brigadesTable;

  private int rowIdx = 0;

  public GridPane initView() {

    initGrid();
    initHeader();
    initLabelsAndText();
    initDamagesTable();
    initEquipmentsTable();
    initFirefightersTable();
    initBrigadesTable();

    return grid;
  }

  private void initHeader() {
    Text scenetitle = new Text("Post Firefighters - raporty");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    scenetitle.setId("welcome-text");
    grid.add(scenetitle, 0, getCurrentRowIdx(), COLUMNS_NUMBER, 1);
  }

  private void initGrid() {
    grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

  }

  private void initLabelsAndText() {
    grid.add(createLabel("Nazwa posterunku"), LABEL_IDX, getNextRowIdx());
    postNameText = createTextField();
    grid.add(postNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Nazwa akcji"), LABEL_IDX, getNextRowIdx());
    actionNameText = createTextField();
    grid.add(actionNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Typ akcji"), LABEL_IDX, getNextRowIdx());
    accidentTypeText = createTextField();
    grid.add(accidentTypeText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Gmina"), LABEL_IDX, getNextRowIdx());
    communityText = createTextField();
    grid.add(communityText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Powierzchnia akcji"), LABEL_IDX, getNextRowIdx());
    areaSizeText = createTextField();
    grid.add(areaSizeText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Nazwa obiektu"), LABEL_IDX, getNextRowIdx());
    objectNameText = createTextField();
    grid.add(objectNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Właściciel obiektu"), LABEL_IDX, getNextRowIdx());
    objectOwnerText = createTextField();
    grid.add(objectOwnerText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Osoba wypełniająca raport"), LABEL_IDX, getNextRowIdx());
    reporterText = createTextField();
    grid.add(reporterText, TEXT_IDX, getCurrentRowIdx());
  }

  private Label createLabel(String text) {
    Label label = new Label(text);
    label.setMinWidth(100);
    return label;
  }

  private TextField createTextField() {
    TextField textField = new TextField();
    textField.setMinWidth(200);
    return textField;
  }

  private void initDamagesTable() {
    grid.add(createLabel("Pozostałe uszkodzenia - TABELA"), LABEL_IDX, getNextRowIdx());

    damagesTable = createTableView();
    TableColumn descriptionColumn = createTableColumn("Opis uszkodzenia", "Description");
    new TableColumn();

    damagesList.add(new ReportDamageGuiModel().setDescription("Przebita opona"));
    damagesList.add(new ReportDamageGuiModel().setDescription("Przebita opona 3"));

    damagesTable.setItems(damagesList);
    damagesTable.getColumns().addAll(descriptionColumn);

    grid.add(damagesTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
  }

  private void initEquipmentsTable() {
    grid.add(createLabel("Użyty ekwipunek - TABELA"), LABEL_IDX, getNextRowIdx());

    equipmentTable = createTableView();

    TableColumn nameColumn = createTableColumn("Nazwa", "name");
    TableColumn workTimeColumn = createTableColumn("Czas pracy", "workTime");
    TableColumn fuelTypeColumn = createTableColumn("Typ paliwa", "fuelType");

    equipmentsList.add(new ReportEquipmentGuiModel()
        .setName("Wóz bojowy 1")
        .setWorkTime("1h")
        .setFuelType("Pb95"));
    equipmentsList.add(new ReportEquipmentGuiModel()
        .setName("Wóz bojowy 2")
        .setWorkTime("3h")
        .setFuelType("ON"));

    equipmentTable.setItems(equipmentsList);
    equipmentTable.getColumns().addAll(nameColumn, workTimeColumn, fuelTypeColumn);

    grid.add(equipmentTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
  }

  private void initFirefightersTable() {
    grid.add(createLabel("Strażacy - TABELA"), LABEL_IDX, getNextRowIdx());

    firefightersTable = createTableView();

    TableColumn nameColumn = createTableColumn("Imię", "name");
    TableColumn surnameColumn = createTableColumn("Nazwisko", "surname");

    firefightersList.add(new ReportFirefighterGuiModel().setName("John").setSurname("Smith"));

    firefightersTable.getColumns().addAll(nameColumn, surnameColumn);
    firefightersTable.setItems(firefightersList);
    grid.add(firefightersTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
  }

  private void initBrigadesTable() {
    grid.add(createLabel("Zastępy - TABELA"), LABEL_IDX, getNextRowIdx());

    brigadesTable = createTableView();

    TableColumn nameColumn = createTableColumn("Nazwa", "name");
    TableColumn nenbersNumberColumn = createTableColumn("Liczba osób", "nenbersNumber");
    TableColumn distanceColumn = createTableColumn("Kilometry", "distance");
    TableColumn departureColumn = createTableColumn("Wyjazd", "departureTime");
    TableColumn arrivalColumn = createTableColumn("Przyjazd", "departureTime");
    TableColumn pumpWorkTimeColumn = createTableColumn("Czas pracy pompy", "pumpWorkTime");

    brigadesList.add(new ReportBrigadeGuiModel()
            .setName("Brygada 1")
            .setMembersNumber("4")
            .setDepartureTime("12:46")
            .setArrivalTime("15:34")
            .setDistance("5km")
            .setPumpWorkTime("2h 23min")
    );

    brigadesTable.setItems(brigadesList);
    brigadesTable.getColumns().addAll(nameColumn, nenbersNumberColumn, distanceColumn, departureColumn, arrivalColumn, pumpWorkTimeColumn);
    grid.add(brigadesTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
  }

  private TableColumn createTableColumn(String header, String property) {
    TableColumn column = new TableColumn(header);
    column.setCellValueFactory(new PropertyValueFactory<>(property));
    column.setMinWidth(80);
    return column;
  }

  private TableView createTableView() {
    TableView table = new TableView<>();
    table.setMinHeight(120);

    return table;
  }

  private int getCurrentRowIdx() {
    return rowIdx;
  }

  private int getNextRowIdx() {
    return ++rowIdx;
  }

}
