package pl.edu.agh.integracja.firefighterspost.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.apache.commons.lang3.StringUtils;
import pl.edu.agh.integracja.firefighterspost.gui.model.*;
import pl.edu.agh.integracja.firefighterspost.service.ReportsService;

import java.util.ArrayList;
import java.util.Arrays;

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
  private TextField reporterText;

  private TableView<ReportDamageGuiModel> damagesTable;
  private TableView<ReportEquipmentGuiModel> equipmentTable;
  private TableView<ReportFirefighterGuiModel> firefightersTable;
  private TableView<ReportBrigadeGuiModel> brigadesTable;

  private int rowIdx = 0;

  private ReportPaneMode displayMode;
  private ReportsService reportsService;
  private Long reportId;

  public ReportPane(ReportsService reportsService, ReportPaneMode displayMode, Long reportId) {
    this.reportsService = reportsService;
    this.displayMode = displayMode;
    this.reportId = reportId;
  }

  public GridPane initView() {
    initGrid();
    initHeader();
    initLabelsAndText();
    initDamagesTableSection();
    initEquipmentsTableSection();
    initFirefightersTableSection();
    initBrigadesTableSection();
    initSendReportPart();

    return grid;
  }

  public void fillWithData(ReportGuiModel model) {
    fillTextIfNotBlank(postNameText, model.getPostName());
    fillTextIfNotBlank(actionNameText, model.getActtionName());
    fillTextIfNotBlank(accidentTypeText, model.getAccidentType());
    fillTextIfNotBlank(communityText, model.getCommunity());
    fillTextIfNotBlank(areaSizeText, model.getAreaSize());
    fillTextIfNotBlank(objectNameText, model.getObjectName());
    fillTextIfNotBlank(objectOwnerText, model.getOwner());
    fillTextIfNotBlank(reporterText, model.getCreator());

    damagesList.addAll(model.getDamages());
    equipmentsList.addAll(model.getUsedEquipment());
    firefightersList.addAll(model.getFirefighters());
    brigadesList.addAll(model.getBrigades());
  }

  private ReportGuiModel readModelFromGui() {
    return new ReportGuiModel()
        .setNotificationId(reportId.toString())
        .setPostName(postNameText.getText())
        .setActtionName(actionNameText.getText())
        .setAccidentType(accidentTypeText.getText())
        .setAreaSize(areaSizeText.getText())
        .setCommunity(communityText.getText())
        .setCreator(reporterText.getText())
        .setObjectName(objectNameText.getText())
        .setOwner(objectOwnerText.getText())
        .setDamages(new ArrayList<>(damagesList))
        .setUsedEquipment(new ArrayList<>(equipmentsList))
        .setFirefighters(new ArrayList<>(firefightersList))
        .setBrigades(new ArrayList<>(brigadesList));
  }

  private void clearAllData() {
    clearText(postNameText);
    clearText(actionNameText);
    clearText(accidentTypeText);
    clearText(communityText);
    clearText(areaSizeText);
    clearText(objectNameText);
    clearText(objectOwnerText);
    clearText(reporterText);

    damagesList.clear();
    equipmentsList.clear();
    firefightersList.clear();
    brigadesList.clear();
  }

  private void clearText(TextField text) {
    text.clear();
  }

  private void fillTextIfNotBlank(TextField postNameText, String postName) {
    if (StringUtils.isBlank(postNameText.getText())) {
      postNameText.setText(postName);
    }
  }

  private void initHeader() {
    Text scenetitle = new Text("Posterunek Straży Pożarnej - Raporty");
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
    grid.add(createLabel("Nazwa posterunku:"), LABEL_IDX, getNextRowIdx());
    postNameText = createTextField("Nazwa posterunku");
    grid.add(postNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Nazwa akcji:"), LABEL_IDX, getNextRowIdx());
    actionNameText = createTextField("Nazwa akcji");
    grid.add(actionNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Typ akcji:"), LABEL_IDX, getNextRowIdx());
    accidentTypeText = createTextField("Typ akcji");
    grid.add(accidentTypeText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Gmina:"), LABEL_IDX, getNextRowIdx());
    communityText = createTextField("Gmina");
    grid.add(communityText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Powierzchnia akcji:"), LABEL_IDX, getNextRowIdx());
    areaSizeText = createTextField("Powierzchnia akcji");
    grid.add(areaSizeText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Nazwa obiektu:"), LABEL_IDX, getNextRowIdx());
    objectNameText = createTextField("Nazwa obiektu");
    grid.add(objectNameText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Właściciel obiektu:"), LABEL_IDX, getNextRowIdx());
    objectOwnerText = createTextField("Właściciel obiektu");
    grid.add(objectOwnerText, TEXT_IDX, getCurrentRowIdx());

    grid.add(createLabel("Osoba wypełniająca raport:"), LABEL_IDX, getNextRowIdx());
    reporterText = createTextField("Osoba wypełniająca raport");
    grid.add(reporterText, TEXT_IDX, getCurrentRowIdx());
  }

  private void initDamagesTableSection() {
    addHorizontalSeparator();
    grid.add(createLabel("Pozostałe uszkodzenia:"), LABEL_IDX, getNextRowIdx());

    damagesTable = createTableView();
    TableColumn descriptionColumn = createTableColumn("Opis uszkodzenia", "Description");
    descriptionColumn.setMinWidth(300);

    damagesTable.setItems(damagesList);
    damagesTable.getColumns().addAll(descriptionColumn);

    grid.add(damagesTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

    if (displayMode.equals(ReportPaneMode.ADD_REPORT)) {
      HBox hbox = createHbox();
      Button damagesButton = new Button("Dodaj uszkodzenie:");
      TextField damagesInputText = createTextField("Opis uszkodzenia");
      hbox.getChildren().addAll(damagesButton, damagesInputText);

      damagesButton.setOnAction(event -> {
        String text = damagesInputText.getText();
        if (StringUtils.isBlank(text)) {
          return;
        }

        damagesList.add(new ReportDamageGuiModel().setDescription(text));
        damagesInputText.clear();
      });
      grid.add(hbox, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
    }
  }

  private void initEquipmentsTableSection() {
    addHorizontalSeparator();
    grid.add(createLabel("Użyty ekwipunek"), LABEL_IDX, getNextRowIdx());

    equipmentTable = createTableView();

    TableColumn nameColumn = createTableColumn("Nazwa", "name");
    TableColumn workTimeColumn = createTableColumn("Czas pracy [h]", "workTime");
    TableColumn fuelTypeColumn = createTableColumn("Typ paliwa", "fuelType");

    equipmentTable.setItems(equipmentsList);
    equipmentTable.getColumns().addAll(nameColumn, workTimeColumn, fuelTypeColumn);

    grid.add(equipmentTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

    if (displayMode.equals(ReportPaneMode.ADD_REPORT)) {

      HBox hbox = createHbox();
      Button addEquipmentButton = new Button("Dodaj wyposażenie");
      TextField nameField = createTextField("Nazwa");
      TextField workTimeField = createTextField("Czas pracy [h]");
      TextField fuelTypeField = createTextField("Typ paliwa");
      hbox.getChildren().addAll(addEquipmentButton, nameField, workTimeField, fuelTypeField);

      addEquipmentButton.setOnAction(event -> {
        if (StringUtils.isBlank(nameField.getText())) {
          return;
        }

        equipmentsList.add(new ReportEquipmentGuiModel()
                .setName(nameField.getText())
                .setWorkTime(workTimeField.getText())
                .setFuelType(fuelTypeField.getText())
        );

        nameField.clear();
        workTimeField.clear();
        fuelTypeField.clear();
      });

      grid.add(hbox, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
    }
  }

  private void initFirefightersTableSection() {
    addHorizontalSeparator();
    grid.add(createLabel("Strażacy"), LABEL_IDX, getNextRowIdx());

    firefightersTable = createTableView();

    TableColumn nameColumn = createTableColumn("Imię", "name");
    TableColumn surnameColumn = createTableColumn("Nazwisko", "surname");

    firefightersTable.getColumns().addAll(nameColumn, surnameColumn);
    firefightersTable.setItems(firefightersList);
    grid.add(firefightersTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

    if (displayMode.equals(ReportPaneMode.ADD_REPORT)) {
      HBox hbox = createHbox();
      Button addFirefighterButton = new Button("Dodaj strażaka");
      TextField nameText = createTextField("Imię");
      TextField surnameText = createTextField("Nazwisko");
      hbox.getChildren().addAll(addFirefighterButton, nameText, surnameText);

      addFirefighterButton.setOnAction(event -> {
        if (StringUtils.isBlank(nameText.getText())) {
          return;
        }
        firefightersList.add(new ReportFirefighterGuiModel()
                .setName(nameText.getText())
                .setSurname(surnameText.getText())
        );

        nameText.clear();
        surnameText.clear();

      });

      grid.add(hbox, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
    }
  }

  private void initBrigadesTableSection() {
    addHorizontalSeparator();
    grid.add(createLabel("Zastępy"), LABEL_IDX, getNextRowIdx());

    brigadesTable = createTableView();

    TableColumn nameColumn = createTableColumn("Nazwa", "name");
    TableColumn nenbersNumberColumn = createTableColumn("Liczba osób", "nenbersNumber");
    TableColumn distanceColumn = createTableColumn("Kilometry", "distance");
    TableColumn departureColumn = createTableColumn("Wyjazd", "departureTime");
    TableColumn arrivalColumn = createTableColumn("Przyjazd", "departureTime");
    TableColumn pumpWorkTimeColumn = createTableColumn("Czas pracy pompy", "pumpWorkTime");

    brigadesTable.setItems(brigadesList);
    brigadesTable.getColumns().addAll(nameColumn, nenbersNumberColumn, distanceColumn, departureColumn, arrivalColumn, pumpWorkTimeColumn);
    grid.add(brigadesTable, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

    if (displayMode.equals(ReportPaneMode.ADD_REPORT)) {
      HBox hbox = createHbox();
      Button addBrigadeButton = new Button("Dodaj zastęp");
      TextField nameField = createTextField("Nazwa");
      TextField membersCountField = createTextField("Liczba osób");
      TextField distanceField = createTextField("Kilometry");
      TextField departureField = createTextField("Wyjazd");
      TextField arrivalField = createTextField("Przyjazd");
      TextField worktimeField = createTextField("Czas pracy pompy");

      hbox.getChildren().addAll(addBrigadeButton, nameField, membersCountField, distanceField, departureField, arrivalField, worktimeField);
      grid.add(hbox, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

      addBrigadeButton.setOnAction(event -> {
        if (StringUtils.isBlank(nameField.getText())) {
          return;
        }

        brigadesList.add(new ReportBrigadeGuiModel()
                .setName(nameField.getText())
                .setMembersNumber(membersCountField.getText())
                .setDistance(distanceField.getText())
                .setDepartureTime(departureField.getText())
                .setArrivalTime(arrivalField.getText())
                .setPumpWorkTime(worktimeField.getText())
        );
      });
    }
  }

  private void initSendReportPart() {
    if (displayMode.equals(ReportPaneMode.VIEW_REPORT)) {
      return;
    }

    addHorizontalSeparator();

    HBox hBox = new HBox();
    Button sendReportBtn = createButton("Wyślij Raport");
    Button fillWithSampleData = createButton("Uzupełnij przykładowymi wartościami");
    Button clearButton = createButton("Wyczyść dane");
    hBox.getChildren().addAll(sendReportBtn, fillWithSampleData, clearButton);
    grid.add(hBox, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);

    sendReportBtn.setOnAction(event -> {

      ReportGuiModel reportModel = readModelFromGui();
      reportsService.sendReport(reportModel);
    });

    fillWithSampleData.setOnAction(event -> {
      fillWithData(new ReportGuiModel()
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
                  .setDistance("3")
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
                  .setWorkTime("1"),
              new ReportEquipmentGuiModel()
                  .setName("Gaśnica")
                  .setWorkTime("1")
                  .setFuelType("-"),
              new ReportEquipmentGuiModel()
                  .setName("Piasek neutralizujący olej")
                  .setFuelType("-")
                  .setWorkTime("0"))));

    });

    clearButton.setOnAction(event -> {
      clearAllData();
    });

  }

  private void addHorizontalSeparator() {
    Separator separator = new Separator(Orientation.HORIZONTAL);
    grid.add(separator, 0, getNextRowIdx(), COLUMNS_NUMBER, 1);
  }

  private Label createLabel(String text) {
    Label label = new Label(text);
    label.setMinWidth(100);
    return label;
  }

  private TextField createTextField(String tooltipAndPromptValue) {
    TextField textField = new TextField();
    textField.setPromptText(tooltipAndPromptValue);
    textField.setTooltip(new Tooltip(tooltipAndPromptValue));
    textField.setMinWidth(100);
    if (displayMode.equals(ReportPaneMode.VIEW_REPORT)) {
      textField.setEditable(false);
    }

    return textField;
  }

  private TableColumn createTableColumn(String header, String property) {
    TableColumn column = new TableColumn(header);
    column.setCellValueFactory(new PropertyValueFactory<>(property));
    column.setMinWidth(100);
    return column;
  }

  private TableView createTableView() {
    TableView table = new TableView<>();
    table.setMinHeight(120);

    if (displayMode.equals(ReportPaneMode.VIEW_REPORT)) {
      table.setEditable(false);
    }

    return table;
  }

  private int getCurrentRowIdx() {
    return rowIdx;
  }

  private int getNextRowIdx() {
    return ++rowIdx;
  }

  private HBox createHbox() {
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 0));
    hbox.setSpacing(10);
    return hbox;
  }

  private Button createButton(String text) {
    Button button = new Button(text);
    button.setMinWidth(100);
    return button;
  }

  public static enum ReportPaneMode {
    ADD_REPORT, VIEW_REPORT;
  }

}
