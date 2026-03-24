package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginController {
    @FXML
    private StackPane loginRoot;
    @FXML
    private VBox loginCard;
    @FXML
    private StackPane logoContainer;
    @FXML
    private Label appNameLabel;
    @FXML
    private Label appTaglineLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private Label usernameErrorLabel;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordErrorLabel;
    @FXML
    private CheckBox rememberMeCheckBox;
    @FXML
    private Label forgotPasswordLink;
    @FXML
    private StackPane errorBanner;
    @FXML
    private Label errorBannerLabel;
    @FXML
    private Button loginButton;
    @FXML
    private StackPane loadingOverlay;
    @FXML
    private ProgressIndicator loginProgress;

    @FXML
    private void handleLogin() {
    }
}
