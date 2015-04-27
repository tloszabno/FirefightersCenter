package pl.edu.agh.integracja.firefighterspost;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppPreloader extends Preloader {
    private Stage stage;

    public void start(Stage stage) throws Exception {

        this.stage = stage;

        Scene scene = new Scene(new ProgressIndicator(-1), 100, 100);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification pn) {

        if (pn instanceof Preloader.StateChangeNotification) {
            stage.hide();
        }
    }
}

