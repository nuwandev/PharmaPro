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
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.logging.Logger;

public class LoginController {
    @FXML
    @SuppressWarnings("unused")
    private StackPane loginRoot;
    @FXML
    @SuppressWarnings("unused")
    private VBox loginCard;
    @FXML
    @SuppressWarnings("unused")
    private StackPane logoContainer;
    @FXML
    @SuppressWarnings("unused")
    private Label appNameLabel;
    @FXML
    @SuppressWarnings("unused")
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

    // Use a single SecureRandom instance for efficiency and security
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    private static String generateToken() {
        return new BigInteger(130, SECURE_RANDOM).toString(32);
    }

    @FXML
    private void initialize() {
        // Hide overlays and banners initially
        loadingOverlay.setVisible(false);
        loadingOverlay.setManaged(false);
        errorBanner.setVisible(false);
        errorBanner.setManaged(false);

        // Attempt auto-login with remember me token
        String token = SessionStorage.loadToken();
        if (token != null && !token.isBlank()) {
            Optional<User> userOpt = authService.findByRememberMeToken(token.trim());
            if (userOpt.isPresent()) {
                SessionContext.setUser(userOpt.get());
                openDashboard();
            } else {
                SessionStorage.clear();
            }
        }
    }

    @FXML
    private void handleLogin() {
        clearErrors();
        setBusy(true);

        final String username = usernameField.getText();
        final String password = passwordField.getText();

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
                String token = generateToken();
                authService.updateRememberMeToken(user.id(), token);
                SessionStorage.saveToken(token);
            } else {
                authService.updateRememberMeToken(user.id(), null);
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
            LOGGER.severe("Failed to load dashboard: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dashboard Load Error");
            alert.setHeaderText("Failed to load dashboard");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
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
