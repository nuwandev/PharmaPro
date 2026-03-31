package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ChangePasswordDialogController {
    @FXML
    private DialogPane dialogPane;
    @FXML
    private PasswordField currentPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleChangePassword() {
        String current = currentPasswordField.getText();
        String newPass = newPasswordField.getText();
        String confirm = confirmPasswordField.getText();
        if (!newPass.equals(confirm)) {
            // Show error (could use a label or dialog)
            currentPasswordField.clear();
            newPasswordField.clear();
            confirmPasswordField.clear();
            return;
        }
        // TODO: Validate current password and update using AuthService
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.close();
    }
}
