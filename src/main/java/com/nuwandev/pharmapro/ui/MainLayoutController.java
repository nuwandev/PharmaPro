package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainLayoutController {
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
    private VBox sidebarFooter;
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
    private HBox userProfileBox;
    @FXML
    private Label topbarUserInitials;
    @FXML
    private Label topbarUserName;
    @FXML
    private Label topbarUserRole;
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
    private void navigateToDashboard() {
    }

    @FXML
    private void navigateToPOS() {
    }

    @FXML
    private void navigateToMedicines() {
    }

    @FXML
    private void navigateToBatches() {
    }

    @FXML
    private void navigateToPurchaseOrders() {
    }

    @FXML
    private void navigateToSuppliers() {
    }

    @FXML
    private void navigateToReports() {
    }

    @FXML
    private void navigateToSettings() {
    }

    @FXML
    private void handleLogout() {
    }

    @FXML
    private void showNotifications() {
    }

    @FXML
    private void showUserMenu() {
    }
}
