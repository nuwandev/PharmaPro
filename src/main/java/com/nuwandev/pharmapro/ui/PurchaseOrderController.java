package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PurchaseOrderController {
    @FXML
    private BorderPane purchaseOrderRoot;
    @FXML
    private StackPane poListView;
    @FXML
    private HBox poToolbar;
    @FXML
    private TextField poSearchField;
    @FXML
    private ComboBox<?> poStatusFilterCombo;
    @FXML
    private ComboBox<?> poSupplierFilterCombo;
    @FXML
    private DatePicker poFromDatePicker;
    @FXML
    private DatePicker poToDatePicker;
    @FXML
    private Button createPOBtn;
    @FXML
    private Label totalPOsValue;
    @FXML
    private Label pendingPOsValue;
    @FXML
    private Label receivedPOsValue;
    @FXML
    private Label totalPOValueLabel;
    @FXML
    private TableView<?> poTable;
    @FXML
    private TableColumn<?, ?> poNumberCol;
    @FXML
    private TableColumn<?, ?> poSupplierCol;
    @FXML
    private TableColumn<?, ?> poStatusCol;
    @FXML
    private TableColumn<?, ?> poItemCountCol;
    @FXML
    private TableColumn<?, ?> poTotalAmountCol;
    @FXML
    private TableColumn<?, ?> poCreatedDateCol;
    @FXML
    private TableColumn<?, ?> poExpectedDateCol;
    @FXML
    private TableColumn<?, ?> poActionsCol;
    @FXML
    private Label poPaginationInfo;
    @FXML
    private Pagination poPagination;
    @FXML
    private VBox poDetailView;
    @FXML
    private Button backToPOListBtn;
    @FXML
    private Label poDetailNumberLabel;
    @FXML
    private Label poDetailStatusBadge;
    @FXML
    private Button saveDraftBtn;
    @FXML
    private Button submitPOBtn;
    @FXML
    private Button markReceivedBtn;
    @FXML
    private Button cancelPOBtn;
    @FXML
    private ComboBox<?> poSupplierCombo;
    @FXML
    private Label supplierContactLabel;
    @FXML
    private Label supplierPhoneLabel;
    @FXML
    private Label supplierEmailLabel;
    @FXML
    private DatePicker poExpectedDeliveryPicker;
    @FXML
    private TextArea poNotesField;
    @FXML
    private Button addPOItemBtn;
    @FXML
    private TableView<?> poItemsTable;
    @FXML
    private TableColumn<?, ?> poItemMedicineCol;
    @FXML
    private TableColumn<?, ?> poItemUnitCol;
    @FXML
    private TableColumn<?, ?> poItemQtyCol;
    @FXML
    private TableColumn<?, ?> poItemReceivedQtyCol;
    @FXML
    private TableColumn<?, ?> poItemUnitCostCol;
    @FXML
    private TableColumn<?, ?> poItemSubtotalCol;
    @FXML
    private TableColumn<?, ?> poItemRemoveCol;
    @FXML
    private Label poSubtotalLabel;
    @FXML
    private Label poTaxLabel;
    @FXML
    private Label poGrandTotalLabel;

    @FXML
    private void openCreatePO() {
    }

    @FXML
    private void backToPOList() {
    }

    @FXML
    private void saveDraft() {
    }

    @FXML
    private void submitPO() {
    }

    @FXML
    private void markAsReceived() {
    }

    @FXML
    private void cancelPO() {
    }

    @FXML
    private void addItemToPO() {
    }
}
