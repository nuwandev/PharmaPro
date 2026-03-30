package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicineFormController {
    @FXML
    private VBox medicineFormRoot;
    @FXML
    private HBox formHeader;
    @FXML
    private Label formTitleLabel;
    @FXML
    private Label formSubtitleLabel;
    @FXML
    private Button closeFormBtn;
    @FXML
    private ScrollPane formScrollPane;
    @FXML
    private VBox formFooter;
    @FXML
    private Label formGlobalError;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button saveAndAddAnotherBtn;
    @FXML
    private Button saveMedicineBtn;
    @FXML
    private GridPane basicInfoGrid;
    @FXML
    private TextField medicineNameField;
    @FXML
    private Label medicineNameError;
    @FXML
    private TextField brandField;
    @FXML
    private Label brandError;
    @FXML
    private ComboBox<?> categoryCombo;
    @FXML
    private Label categoryError;
    @FXML
    private ComboBox<?> unitCombo;
    @FXML
    private Label unitError;
    @FXML
    private TextField barcodeField;
    @FXML
    private Button scanBarcodeBtn;
    @FXML
    private RadioButton statusActiveRadio;
    @FXML
    private RadioButton statusInactiveRadio;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField defaultPurchasePriceField;
    @FXML
    private TextField defaultSellPriceField;
    @FXML
    private Label sellPriceError;
    @FXML
    private Spinner<?> reorderLevelSpinner;
    @FXML
    private TextField taxRateField;
    @FXML
    private CheckBox requiresPrescriptionCheck;
    @FXML
    private CheckBox fractionalQtyCheck;
    @FXML
    private VBox initialBatchSection;
    @FXML
    private CheckBox addInitialBatchCheck;
    @FXML
    private GridPane initialBatchGrid;
    @FXML
    private TextField initBatchNumberField;
    @FXML
    private TextField initBatchQtyField;
    @FXML
    private DatePicker initBatchExpiryPicker;
    @FXML
    private TextField initBatchPurchasePriceField;

    @FXML
    private void closeForm() {
    }

    @FXML
    private void saveMedicine() {
    }

    @FXML
    private void deleteMedicine() {
    }

    @FXML
    private void cancelForm() {
    }

    @FXML
    private void saveAndAddAnother() {
    }

    @FXML
    private void scanBarcode() {
    }
}
