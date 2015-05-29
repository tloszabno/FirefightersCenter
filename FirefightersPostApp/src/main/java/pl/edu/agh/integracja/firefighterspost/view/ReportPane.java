package pl.edu.agh.integracja.firefighterspost.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ReportPane {

  private static final int COLUMNS_NUMBER = 2;
  private static final int LABEL_IDX = 0;
  private static final int TEXT_IDX = 1;

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

  public GridPane initView() {

    initGrid();
    initHeader();
    initLabelsAndText();

    return grid;
  }

  private void initHeader() {
    Text scenetitle = new Text("Post Firefighters - raporty");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    scenetitle.setId("welcome-text");
    grid.add(scenetitle, 0, 0, COLUMNS_NUMBER, 1);
  }

  private void initGrid() {
    grid = new GridPane();
    grid.setAlignment(Pos.TOP_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

  }

  private void initLabelsAndText() {
    int rowIdx = 1;

    grid.add(createLabel("Nazwa posterunku"), LABEL_IDX, rowIdx);
    postNameText = createTextField();
    grid.add(postNameText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Nazwa akcji"), LABEL_IDX, rowIdx);
    actionNameText = createTextField();
    grid.add(actionNameText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Typ akcji"), LABEL_IDX, rowIdx);
    accidentTypeText = createTextField();
    grid.add(accidentTypeText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Gmina"), LABEL_IDX, rowIdx);
    communityText = createTextField();
    grid.add(communityText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Powierzchnia akcji"), LABEL_IDX, rowIdx);
    areaSizeText = createTextField();
    grid.add(areaSizeText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Nazwa obiektu"), LABEL_IDX, rowIdx);
    objectNameText = createTextField();
    grid.add(objectNameText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Właściciel obiektu"), LABEL_IDX, rowIdx);
    objectOwnerText = createTextField();
    grid.add(objectOwnerText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Pozostałe uszkodzenia - TABELA"), LABEL_IDX, rowIdx);
    otherDamagesText = createTextField();
    grid.add(otherDamagesText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Osoba wypełniająca raport"), LABEL_IDX, rowIdx);
    reporterText = createTextField();
    grid.add(reporterText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Użyty ekwipunek - TABELA"), LABEL_IDX, rowIdx);
    usedEquipmentText = createTextField();
    grid.add(usedEquipmentText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Strażacy - TABELA"), LABEL_IDX, rowIdx);
    firefightersText = createTextField();
    grid.add(firefightersText, TEXT_IDX, rowIdx);
    rowIdx++;

    grid.add(createLabel("Zastępy - TABELA"), LABEL_IDX, rowIdx);
    brigadesText = createTextField();
    grid.add(brigadesText, TEXT_IDX, rowIdx);
    rowIdx++;

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

}
