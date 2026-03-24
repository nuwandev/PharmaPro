package com.nuwandev.pharmapro.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PharmaProApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PharmaPro Login");
        stage.setScene(scene);
        stage.show();
    }
}
