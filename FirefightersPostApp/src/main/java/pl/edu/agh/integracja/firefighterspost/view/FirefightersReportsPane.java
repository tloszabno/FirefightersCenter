package pl.edu.agh.integracja.firefighterspost.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FirefightersReportsPane {

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
    grid.add(scenetitle, 0, 0, 1, 1);
  }

}
