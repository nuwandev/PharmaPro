package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BatchManagementController {
    @FXML
    private VBox batchManagementRoot;
    @FXML
    private VBox standaloneHeader;
    @FXML
    private HBox batchToolbar;
    @FXML
    private ComboBox<?> medicineSelectorCombo;
    @FXML
    private ComboBox<?> batchStatusFilterCombo;
    @FXML
    private ComboBox<?> expiryRangeCombo;
    @FXML
    private TextField batchSearchField;
    @FXML
    private Label batchResultCount;
    @FXML
    private HBox batchKpiStrip;
    @FXML
    private Label totalBatchesValue;
    @FXML
    private Label expiringSoonBatchValue;
    @FXML
    private Label expiredBatchValue;
    @FXML
    private Label activeBatchValue;
    @FXML
    private TableView<?> batchTable;
    @FXML
    private TableColumn<?, ?> batchMedicineNameCol;
    @FXML
    private TableColumn<?, ?> batchNumberTableCol;
    @FXML
    private TableColumn<?, ?> batchQtyTableCol;
    @FXML
    private TableColumn<?, ?> batchPurchasePriceCol;
    @FXML
    private TableColumn<?, ?> batchSellPriceCol;
    @FXML
    private TableColumn<?, ?> batchExpiryDateCol;
    @FXML
    private TableColumn<?, ?> batchDaysLeftTableCol;
    @FXML
    private TableColumn<?, ?> batchStatusTableCol;
    @FXML
    private TableColumn<?, ?> batchActionsCol;
    @FXML
    private Label batchPaginationInfo;
    @FXML
    private Pagination batchPagination;
    @FXML
    private Button addBatchStandaloneBtn;
    @FXML
    private Button exportBatchBtn;
    @FXML
    private StackPane addBatchModalOverlay;
    @FXML
    private VBox addBatchDialog;
    @FXML
    private Label batchModalTitle;
    @FXML
    private Button closeBatchModalBtn;
    @FXML
    private VBox batchMedicineSelectRow;
    @FXML
    private ComboBox<?> batchMedicineCombo;
    @FXML
    private Label batchMedicineError;
    @FXML
    private TextField batchNumberInputField;
    @FXML
    private Label batchNumberError;
    @FXML
    private TextField batchQtyInputField;
    @FXML
    private Label batchQtyError;
    @FXML
    private TextField purchasePriceInputField;
    @FXML
    private TextField sellPriceInputField;
    @FXML
    private DatePicker expiryDatePicker;
    @FXML
    private Label expiryDateError;
    @FXML
    private DatePicker manufactureDatePicker;
    @FXML
    private ComboBox<?> batchSupplierCombo;
    @FXML
    private TextField storageLocationField;
    @FXML
    private TextArea batchNotesField;
    @FXML
    private Label batchFormGlobalError;
    @FXML
    private Button cancelAddBatchBtn;
    @FXML
    private Button saveBatchBtn;

    @FXML
    private void openAddBatchModal() {
    }

    @FXML
    private void closeAddBatchModal() {
    }

    @FXML
    private void exportBatches() {
    }

    @FXML
    private void saveBatch() {
    }
}
