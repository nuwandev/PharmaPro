package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SupplierController {
    @FXML
    private StackPane supplierRoot;
    @FXML
    private HBox supplierToolbar;
    @FXML
    private TextField supplierSearchField;
    @FXML
    private ComboBox<?> supplierStatusFilter;
    @FXML
    private Label supplierCountLabel;
    @FXML
    private Button addSupplierBtn;
    @FXML
    private TableView<?> supplierTable;
    @FXML
    private TableColumn<?, ?> supplierNameCol;
    @FXML
    private TableColumn<?, ?> supplierContactPersonCol;
    @FXML
    private TableColumn<?, ?> supplierPhoneCol;
    @FXML
    private TableColumn<?, ?> supplierEmailCol;
    @FXML
    private TableColumn<?, ?> supplierAddressCol;
    @FXML
    private TableColumn<?, ?> supplierStatusCol;
    @FXML
    private TableColumn<?, ?> supplierActionsCol;
    @FXML
    private Label supplierPaginationInfo;
    @FXML
    private Pagination supplierPagination;
    @FXML
    private StackPane supplierModalOverlay;
    @FXML
    private VBox supplierDialog;
    @FXML
    private Label supplierModalTitle;
    @FXML
    private Button closeSupplierModalBtn;
    @FXML
    private TextField supplierNameField;
    @FXML
    private Label supplierNameError;
    @FXML
    private TextField supplierContactField;
    @FXML
    private TextField supplierPhoneField;
    @FXML
    private Label supplierPhoneError;
    @FXML
    private TextField supplierEmailField;
    @FXML
    private Label supplierEmailError;
    @FXML
    private TextField supplierWebsiteField;
    @FXML
    private TextArea supplierAddressField;
    @FXML
    private TextField supplierTaxNumberField;
    @FXML
    private ComboBox<?> paymentTermsCombo;
    @FXML
    private RadioButton supplierActiveRadio;
    @FXML
    private RadioButton supplierInactiveRadio;
    @FXML
    private CheckBox preferredSupplierCheck;
    @FXML
    private TextArea supplierNotesField;
    @FXML
    private Label supplierFormError;
    @FXML
    private Button cancelSupplierBtn;
    @FXML
    private Button saveSupplierBtn;
    @FXML
    private StackPane deleteConfirmOverlay;
    @FXML
    private Label deleteConfirmMessage;
    @FXML
    private Button cancelDeleteBtn;
    @FXML
    private Button confirmDeleteBtn;

    @FXML
    private void openAddSupplier() {
    }

    @FXML
    private void closeSupplierModal() {
    }

    @FXML
    private void saveSupplier() {
    }

    @FXML
    private void cancelDelete() {
    }

    @FXML
    private void confirmDelete() {
    }
}
