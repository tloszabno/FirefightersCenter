package pl.edu.agh.integracja.firefighterspost.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainAppPane implements AlertListener {

    private Label alarmReceivedLbl;
    private Button confirmAlertBtn;
    private Text confirmationTxt;

    public GridPane init() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Post Firefighters");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scenetitle.setId("welcome-text");

        grid.add(scenetitle, 0, 0, 2, 1);

        alarmReceivedLbl = new Label("");
        grid.add(alarmReceivedLbl, 0, 1, 2, 1);

        confirmAlertBtn = new Button("Confirm Alert");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(confirmAlertBtn);
        grid.add(hbBtn, 1, 4, 2, 1);

        confirmationTxt = new Text();
        confirmationTxt.setId("confirmationTxt");

        grid.add(confirmationTxt, 1, 6);

        confirmAlertBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                confirmationTxt.setFill(Color.FIREBRICK);
                confirmationTxt.setText("Alert Confirmed");
                alarmReceivedLbl.setText("");
                confirmAlertBtn.setDisable(true);
            }
        });
        confirmAlertBtn.setDisable(true);

        return grid;
    }


    @Override
    public void onAlertReceive(String message) {
        Platform.runLater(() -> {
            confirmAlertBtn.setDisable(false);
            alarmReceivedLbl.setText("Received Alarm: " + message);
            confirmationTxt.setText("");
        });

    }
}
