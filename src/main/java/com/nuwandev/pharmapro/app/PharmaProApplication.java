package com.nuwandev.pharmapro.app;


import com.nuwandev.pharmapro.database.DatabaseContext;
import com.nuwandev.pharmapro.model.User;
import com.nuwandev.pharmapro.repository.UserRepository;
import com.nuwandev.pharmapro.session.SessionContext;
import com.nuwandev.pharmapro.session.SessionStorage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Optional;

public class PharmaProApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String rememberedUsername = SessionStorage.load();

        Parent root;
        String title;
        boolean isMain = false;
        if (rememberedUsername != null && !rememberedUsername.isBlank()) {
            UserRepository userRepository = new UserRepository(
                    DatabaseContext.getDataSource());
            Optional<User> userOpt = userRepository.findByUsername(rememberedUsername.trim());
            if (userOpt.isPresent()) {
                SessionContext.setUser(userOpt.get());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/main_layout.fxml"));
                root = loader.load();
                title = "PharmaPro";
                isMain = true;
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/login.fxml"));
                root = loader.load();
                title = "PharmaPro Login";
            }
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/login.fxml"));
            root = loader.load();
            title = "PharmaPro Login";
        }

        Scene scene;
        if (isMain) {
            scene = new Scene(root, 1280, 800);
            stage.setMinWidth(900);
            stage.setMinHeight(600);
            stage.setResizable(true);
        } else {
            scene = new Scene(root, 420, 640);
            stage.setResizable(false);
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
