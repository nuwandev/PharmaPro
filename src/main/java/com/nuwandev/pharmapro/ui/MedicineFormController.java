package com.nuwandev.pharmapro.ui;

import com.nuwandev.pharmapro.enums.MedicineStatus;
import com.nuwandev.pharmapro.model.Medicine;
import com.nuwandev.pharmapro.service.MedicineService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicineFormController {
    private MedicineService medicineService = new MedicineService();
    private Medicine editingMedicine = null;
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

    public void setMedicine(Medicine medicine) {
        this.editingMedicine = medicine;
        if (medicine != null) {
            medicineNameField.setText(medicine.name());
            brandField.setText(medicine.brand());
            barcodeField.setText(medicine.barcode());
            descriptionField.setText(medicine.description());
            statusActiveRadio.setSelected(medicine.status() == MedicineStatus.ACTIVE);
            statusInactiveRadio.setSelected(medicine.status() == MedicineStatus.INACTIVE);
            // TODO: Set category/unit
        }
    }

    // --- Close dialog with fade-out ---
    @FXML
    private void closeForm() {
        javafx.stage.Stage stage = (javafx.stage.Stage) medicineFormRoot.getScene().getWindow();
        javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.millis(180), medicineFormRoot);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setOnFinished(e -> stage.close());
        fade.play();
    }

    @FXML
    private void saveMedicine() {
        try {
            Medicine m = new Medicine(
                    editingMedicine != null ? editingMedicine.id() : null,
                    medicineNameField.getText(),
                    brandField.getText(),
                    null, // TODO: categoryId
                    unitCombo.getValue() != null ? unitCombo.getValue().toString() : null,
                    barcodeField.getText(),
                    statusActiveRadio.isSelected() ? MedicineStatus.ACTIVE : MedicineStatus.INACTIVE,
                    descriptionField.getText(),
                    null, // TODO: defaultPurchasePrice
                    null, // TODO: defaultSellPrice
                    0, // TODO: reorderLevel
                    null, // TODO: taxRate
                    false, // TODO: requiresPrescription
                    false, // TODO: allowFractionalQty
                    null, null
            );
            if (editingMedicine == null) {
                medicineService.add(m);
            } else {
                medicineService.update(m);
            }
            closeForm();
        } catch (Exception e) {
            // TODO: Show error dialog
        }
    }

    @FXML
    private void deleteMedicine() {
    }

    @FXML
    private void cancelForm() {
        closeForm();
    }

    @FXML
    private void saveAndAddAnother() {
        saveMedicine();
        setMedicine(null);
    }

    @FXML
    private void scanBarcode() {
    }
}
