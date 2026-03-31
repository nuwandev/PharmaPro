package com.nuwandev.pharmapro.ui;

import com.nuwandev.pharmapro.session.SessionContext;
import com.nuwandev.pharmapro.session.SessionStorage;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainLayoutController implements Initializable {

    private static final String NAV_ACTIVE = "nav-item-active";
    private static final String NAV_INACTIVE = "nav-item";
    // ── FXML fields ────────────────────────────────────────────
    @FXML
    private BorderPane mainRoot;
    @FXML
    private VBox sidebar;
    @FXML
    private HBox sidebarBrand;
    @FXML
    private ScrollPane sidebarScrollPane;
    @FXML
    private VBox navContainer;
    @FXML
    private Button navDashboard;
    @FXML
    private Button navPOS;
    @FXML
    private Button navMedicines;
    @FXML
    private Button navBatches;
    @FXML
    private Button navPurchaseOrders;
    @FXML
    private Button navSuppliers;
    @FXML
    private Button navReports;
    @FXML
    private Button navSettings;
    @FXML
    private HBox sidebarFooter;
    @FXML
    private Label sidebarUserInitials;
    @FXML
    private Label sidebarUserName;
    @FXML
    private Label sidebarUserRole;
    @FXML
    private Button logoutBtn;
    @FXML
    private HBox topbar;
    @FXML
    private Label topbarPageTitle;
    @FXML
    private Label topbarBreadcrumb;
    @FXML
    private TextField globalSearchField;
    @FXML
    private Button notificationBtn;
    @FXML
    private Label notifBadge;
    @FXML
    private StackPane contentArea;
    @FXML
    private Label contentPlaceholder;
    @FXML
    private StackPane toastContainer;
    @FXML
    private VBox toastBox;
    @FXML
    private Label toastMessage;
    @FXML
    private Button sidebarToggleBtn;
    // ── State ───────────────────────────────────────────────────
    private Button activeNavButton;
    private boolean sidebarCollapsed = false;

    // ── Init ────────────────────────────────────────────────────
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateUserInfo();
        navigateToDashboard();   // load default screen
    }

    private void populateUserInfo() {
        String fullName = SessionContext.getFullName();
        String role = SessionContext.getRole();

        // Derive initials — "Admin User" → "AU"
        String initials = buildInitials(fullName);

        sidebarUserInitials.setText(initials);
        sidebarUserName.setText(fullName);
        sidebarUserRole.setText(role);

    }

    private String buildInitials(String fullName) {
        if (fullName == null || fullName.isBlank()) return "?";
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) return parts[0].substring(0, 1).toUpperCase();
        return (parts[0].substring(0, 1) + parts[parts.length - 1].substring(0, 1)).toUpperCase();
    }

    // ── Navigation ──────────────────────────────────────────────

    @FXML
    private void navigateToDashboard() {
        loadScreen("dashboard.fxml", navDashboard, "Dashboard", "Home / Dashboard");
    }

    @FXML
    private void navigateToPOS() {
        loadScreen("pos_sales.fxml", navPOS, "Point of Sale", "Home / POS");
    }

    @FXML
    private void navigateToMedicines() {
        loadScreen("medicine_catalog.fxml", navMedicines, "Medicines", "Inventory / Medicines");
    }

    @FXML
    private void navigateToBatches() {
        loadScreen("batch_management.fxml", navBatches, "Batch Management", "Inventory / Batches");
    }

    @FXML
    private void navigateToPurchaseOrders() {
        loadScreen("purchase_orders.fxml", navPurchaseOrders, "Purchase Orders", "Inventory / PO");
    }

    @FXML
    private void navigateToSuppliers() {
        loadScreen("supplier_management.fxml", navSuppliers, "Suppliers", "Inventory / Suppliers");
    }

    @FXML
    private void navigateToReports() {
        loadScreen("reports.fxml", navReports, "Reports", "Reports");
    }

    @FXML
    private void navigateToSettings() {
        loadScreen("settings.fxml", navSettings, "Settings", "Settings");
    }

    private void loadScreen(String fxmlFile, Button navBtn, String pageTitle, String breadcrumb) {
        try {
            URL resource = getClass().getResource("/com/nuwandev/pharmapro/" + fxmlFile);
            if (resource == null) {
                showToast("Screen not found: " + fxmlFile, ToastType.ERROR);
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Parent screen = loader.load();

            // Swap active nav button styling
            setActiveNav(navBtn);

            // Update topbar
            topbarPageTitle.setText(pageTitle);
            topbarBreadcrumb.setText(breadcrumb);

            // Fade transition for smooth screen swap
            screen.setOpacity(0);
            contentArea.getChildren().setAll(screen);

            FadeTransition fade = new FadeTransition(Duration.millis(180), screen);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();

        } catch (IOException e) {
            e.printStackTrace();
            showToast("Failed to load screen: " + fxmlFile, ToastType.ERROR);
        }
    }

    private void setActiveNav(Button next) {
        // Remove active style from current button
        if (activeNavButton != null) {
            activeNavButton.getStyleClass().remove(NAV_ACTIVE);
            if (!activeNavButton.getStyleClass().contains(NAV_INACTIVE)) {
                activeNavButton.getStyleClass().add(NAV_INACTIVE);
            }
        }

        // Apply active style to new button
        next.getStyleClass().remove(NAV_INACTIVE);
        if (!next.getStyleClass().contains(NAV_ACTIVE)) {
            next.getStyleClass().add(NAV_ACTIVE);
        }

        activeNavButton = next;
    }

    // ── Logout ──────────────────────────────────────────────────

    @FXML
    private void handleLogout() {
        SessionContext.clear();
        SessionStorage.clear();
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/nuwandev/pharmapro/login.fxml")
            );
            Parent loginRoot = loader.load();
            switchScene(loginRoot, "PharmaPro Login", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchScene(Parent root, String title, boolean maximize) {
        Stage stage = (Stage) mainRoot.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle(title);
        stage.setResizable(maximize);
        if (maximize) {
            stage.setMaximized(true);
        } else {
            stage.setMaximized(false);
            stage.sizeToScene();
            stage.centerOnScreen();
        }
    }

    // ── Notifications ────────────────────────────────────────────

    @FXML
    private void showNotifications() {
        // TODO: replace with a real notification popover
        showToast("No new notifications", ToastType.INFO);
    }

    // Sidebar user menu (left bottom corner)
    @FXML
    private void showSidebarUserMenu(javafx.scene.input.MouseEvent event) {
        if (event.getButton() != MouseButton.PRIMARY) return;
        ContextMenu menu = new ContextMenu();
        MenuItem profile = new MenuItem("Profile");
        MenuItem changePassword = new MenuItem("Change Password");
        MenuItem logout = new MenuItem("Logout");
        profile.setOnAction(e -> showProfileDialog());
        changePassword.setOnAction(e -> showChangePasswordDialog());
        logout.setOnAction(e -> handleLogout());
        menu.getItems().addAll(profile, changePassword, logout);
        menu.show(sidebarFooter, event.getScreenX(), event.getScreenY());
    }

    private void showProfileDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/profile_dialog.fxml"));
            DialogPane dialogPane = loader.load();
            javafx.scene.control.Dialog<Void> dialog = new javafx.scene.control.Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("User Profile");
            dialog.showAndWait();
        } catch (Exception e) {
            showToast("Failed to open profile dialog", ToastType.ERROR);
        }
    }

    private void showChangePasswordDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/change_password_dialog.fxml"));
            DialogPane dialogPane = loader.load();
            javafx.scene.control.Dialog<Void> dialog = new javafx.scene.control.Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("Change Password");
            dialog.showAndWait();
        } catch (Exception e) {
            showToast("Failed to open change password dialog", ToastType.ERROR);
        }
    }

    // ── Toast system ─────────────────────────────────────────────

    public void showToast(String message, ToastType type) {
        Platform.runLater(() -> {
            toastMessage.setText(message);

            // Colour the left border by type
            String accent = switch (type) {
                case SUCCESS -> "#0d9488";
                case ERROR -> "#ef4444";
                case INFO -> "#3b82f6";
            };
            toastBox.setStyle(toastBox.getStyle()
                    + "-fx-border-color: " + accent + " transparent transparent transparent;"
                    + "-fx-border-width: 3px 0 0 0;");

            // Show with fade-in
            toastContainer.setVisible(true);
            toastContainer.setManaged(false); // Always keep managed false to avoid layout push

            FadeTransition fadeIn = new FadeTransition(Duration.millis(200), toastContainer);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            // Auto-dismiss after 3 s
            PauseTransition hold = new PauseTransition(Duration.seconds(3));
            hold.setOnFinished(e -> {
                FadeTransition fadeOut = new FadeTransition(Duration.millis(300), toastContainer);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(ev -> {
                    toastContainer.setVisible(false);
                    toastContainer.setManaged(false);
                });
                fadeOut.play();
            });
            hold.play();
        });
    }

    public void showToast(String message) {
        showToast(message, ToastType.INFO);
    }

    public enum ToastType {SUCCESS, ERROR, INFO}

    @FXML
    private void toggleSidebar() {
        sidebarCollapsed = !sidebarCollapsed;
        sidebar.setPrefWidth(sidebarCollapsed ? 60 : 220);
        // Hide/show sidebar text labels and section headers
        for (javafx.scene.Node node : navContainer.getChildren()) {
            if (node instanceof Button btn) {
                btn.setContentDisplay(sidebarCollapsed ? javafx.scene.control.ContentDisplay.GRAPHIC_ONLY : javafx.scene.control.ContentDisplay.LEFT);
            } else if (node instanceof Label lbl) {
                lbl.setVisible(!sidebarCollapsed);
                lbl.setManaged(!sidebarCollapsed);
            }
        }
        sidebarBrand.setVisible(!sidebarCollapsed);
        sidebarBrand.setManaged(!sidebarCollapsed);
        sidebarFooter.setVisible(!sidebarCollapsed);
        sidebarFooter.setManaged(!sidebarCollapsed);
    }
}