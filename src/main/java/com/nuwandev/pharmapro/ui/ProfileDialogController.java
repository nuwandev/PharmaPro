package com.nuwandev.pharmapro.ui;

import com.nuwandev.pharmapro.session.SessionContext;
import com.nuwandev.pharmapro.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileDialogController {
    @FXML private DialogPane dialogPane;
    @FXML private TextField fullNameField;
    @FXML private TextField usernameField;
    @FXML private TextField roleField;

    @FXML
    public void initialize() {
        User user = SessionContext.getUser();
        if (user != null) {
            fullNameField.setText(user.fullName());
            usernameField.setText(user.username());
            roleField.setText(user.role() != null ? user.role().name() : "");
        }
    }

    @FXML
    private void handleClose() {
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.close();
    }
}
