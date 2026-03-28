package com.nuwandev.pharmapro.ui;

import com.nuwandev.pharmapro.factory.ServiceFactory;
import com.nuwandev.pharmapro.model.User;
import com.nuwandev.pharmapro.service.AuthService;
import com.nuwandev.pharmapro.session.SessionContext;
import com.nuwandev.pharmapro.session.SessionStorage;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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

    private final AuthService authService = ServiceFactory.authService();

    @FXML
    private void initialize() {
        loadingOverlay.setVisible(false);
        loadingOverlay.setManaged(false);
        errorBanner.setVisible(false);
        errorBanner.setManaged(false);

        String rememberedUsername = SessionStorage.load();
        if (rememberedUsername != null && !rememberedUsername.isBlank()) {
            usernameField.setText(rememberedUsername);
            rememberMeCheckBox.setSelected(true);
        }
    }

    @FXML
    private void handleLogin() {
        clearErrors();
        setBusy(true);

        String username = usernameField.getText();
        String password = passwordField.getText();

        Task<Optional<User>> task = new Task<>() {
            @Override
            protected Optional<User> call() {
                return authService.login(username, password);
            }
        };

        task.setOnSucceeded(e -> {
            setBusy(false);

            Optional<User> userOpt = task.getValue();
            if (userOpt.isEmpty()) {
                showGlobalError("Invalid username or password.");
                return;
            }

            User user = userOpt.get();
            SessionContext.setUser(user);

            if (rememberMeCheckBox.isSelected()) {
                SessionStorage.save(user.username());
            } else {
                SessionStorage.clear();
            }

            openDashboard();
        });

        task.setOnFailed(e -> {
            setBusy(false);
            showGlobalError("An error occurred while trying to log in. Please try again.");
        });

        Thread thread = new Thread(task, "login-task");
        thread.setDaemon(true);
        thread.start();
    }

    private void openDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/main_layout.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.getScene().setRoot(root);
            stage.setTitle("PharmaPro");
            stage.setResizable(true);
            stage.setMaximized(true);
        } catch (IOException e) {
            showGlobalError("Login worked, but dashboard failed to load. Please contact support.");
            e.printStackTrace();
        }
    }

    private void setBusy(boolean busy) {
        loadingOverlay.setVisible(busy);
        loadingOverlay.setManaged(busy);
        loginButton.setDisable(busy);
        usernameField.setDisable(busy);
        passwordField.setDisable(busy);
        rememberMeCheckBox.setDisable(busy);
        forgotPasswordLink.setDisable(busy);
    }

    private void clearErrors() {
        usernameErrorLabel.setVisible(false);
        usernameErrorLabel.setManaged(false);
        passwordErrorLabel.setVisible(false);
        passwordErrorLabel.setManaged(false);
        errorBanner.setVisible(false);
        errorBanner.setManaged(false);
    }

    private void showGlobalError(String message) {
        errorBannerLabel.setText(message);
        errorBanner.setVisible(true);
        errorBanner.setManaged(true);
    }
}
