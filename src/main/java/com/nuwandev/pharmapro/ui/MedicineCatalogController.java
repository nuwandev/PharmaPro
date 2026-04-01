package com.nuwandev.pharmapro.ui;

import com.nuwandev.pharmapro.model.Medicine;
import com.nuwandev.pharmapro.service.MedicineService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

public class MedicineCatalogController {
    private final MedicineService medicineService = new MedicineService();
    private final ObservableList<Medicine> medicineList = FXCollections.observableArrayList();
    @FXML
    private BorderPane catalogRoot;
    @FXML
    private HBox catalogToolbar;
    @FXML
    private TextField medicineSearchField;
    @FXML
    private ComboBox<?> categoryFilterCombo;
    @FXML
    private ComboBox<?> expiryStatusFilterCombo;
    @FXML
    private ComboBox<?> stockStatusFilterCombo;
    @FXML
    private Button clearFiltersBtn;
    @FXML
    private Button importCsvBtn;
    @FXML
    private Button addMedicineBtn;
    @FXML
    private HBox filterSummaryRow;
    @FXML
    private Label resultCountLabel;
    @FXML
    private HBox activeFilterChips;
    @FXML
    private VBox card;
    @FXML
    private HBox tableHeaderRow;
    @FXML
    private Label selectedCountLabel;
    @FXML
    private Button bulkDeleteBtn;
    @FXML
    private Button columnToggleBtn;
    @FXML
    private TableView<Medicine> medicineTable;
    @FXML
    private TableColumn<?, ?> selectCol;
    @FXML
    private TableColumn<Medicine, String> medicineNameCol;
    @FXML
    private TableColumn<Medicine, String> medicineBrandCol;
    @FXML
    private TableColumn<Medicine, String> medicineCategoryCol;
    @FXML
    private TableColumn<Medicine, String> medicineUnitCol;
    @FXML
    private TableColumn<Medicine, Number> medicineTotalQtyCol;
    @FXML
    private TableColumn<Medicine, Number> medicineExpiringBatchesCol;
    @FXML
    private TableColumn<Medicine, Number> medicineSellPriceCol;
    @FXML
    private TableColumn<Medicine, String> medicineStatusCol;
    @FXML
    private TableColumn<Medicine, Void> medicineActionsCol;
    @FXML
    private HBox tableFooter;
    @FXML
    private Label paginationInfoLabel;
    @FXML
    private Pagination medicinePagination;
    @FXML
    private VBox medicineDrawer;
    @FXML
    private HBox drawerHeader;
    @FXML
    private Label drawerMedicineName;
    @FXML
    private Label drawerMedicineBrand;
    @FXML
    private Button closeDrawerBtn;
    @FXML
    private ScrollPane drawerScrollPane;
    @FXML
    private VBox drawerBatchTableCard;
    @FXML
    private TableView<?> drawerBatchTable;
    @FXML
    private TableColumn<?, ?> batchNumberCol;
    @FXML
    private TableColumn<?, ?> batchQtyCol;
    @FXML
    private TableColumn<?, ?> batchExpiryCol;
    @FXML
    private TableColumn<?, ?> batchDaysLeftCol;
    @FXML
    private TableColumn<?, ?> batchStatusCol;
    @FXML
    private HBox drawerFooter;
    @FXML
    private Button drawerEditBtn;
    @FXML
    private Button drawerDeleteBtn;
    @FXML
    private Button addBatchBtn;
    @FXML
    private Label drawerCategory;
    @FXML
    private Label drawerUnit;
    @FXML
    private Label drawerTotalStock;
    @FXML
    private Label drawerReorderLevel;
    @FXML
    private Label drawerStatusBadge;
    @FXML
    private VBox drawerDescriptionCard;
    @FXML
    private Label drawerDescription;

    @FXML
    private void clearFilters() {
    }

    @FXML
    private void importCSV() {
    }

    @FXML
    private void openAddMedicine() {
        openMedicineFormDialog(null);
    }

    private void openEditMedicine(Medicine medicine) {
        openMedicineFormDialog(medicine);
    }

    private void openMedicineFormDialog(Medicine medicine) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nuwandev/pharmapro/add_edit_medicine.fxml"));
            Parent root = loader.load();
            MedicineFormController controller = loader.getController();
            controller.setMedicine(medicine);

            Stage dialogStage = new Stage();
            Scene scene = new Scene(root);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            dialogStage.setScene(scene);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initStyle(StageStyle.TRANSPARENT);
            if (catalogRoot != null && catalogRoot.getScene() != null && catalogRoot.getScene().getWindow() instanceof Stage owner) {
                dialogStage.initOwner(owner);
            }
            dialogStage.setTitle(medicine == null ? "Add Medicine" : "Edit Medicine");

            scene.getRoot().setOnKeyPressed(event -> {
                if (event.getCode() == javafx.scene.input.KeyCode.ESCAPE) {
                    dialogStage.close();
                }
            });

            // Fade in
            root.setOpacity(0);
            dialogStage.show();
            javafx.animation.FadeTransition fadeIn = new javafx.animation.FadeTransition(javafx.util.Duration.millis(180), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            dialogStage.setOnShown(ev -> root.requestFocus());
            dialogStage.setOnHiding(ev -> {
                try {
                    medicineList.setAll(medicineService.listAll());
                } catch (Exception ignored) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteMedicine(Medicine medicine) {
        if (medicine == null) return;
        try {
            medicineService.delete(medicine.id());
            medicineList.remove(medicine);
        } catch (Exception e) {
            // TODO: Show error dialog
        }
    }

    @FXML
    public void initialize() {
        try {
            medicineList.setAll(medicineService.listAll());
            medicineTable.setItems(medicineList);
            medicineNameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().name()));
            medicineBrandCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().brand()));
            medicineCategoryCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().categoryId()))); // Replace with category name lookup if needed
            medicineUnitCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().unit()));
            medicineTotalQtyCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(0)); // TODO: Replace with real total qty
            medicineExpiringBatchesCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(0)); // TODO: Replace with real expiring batch count
            medicineSellPriceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().defaultSellPrice()));
            medicineStatusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().status() != null ? data.getValue().status().name() : ""));
            medicineActionsCol.setCellFactory(col -> new javafx.scene.control.TableCell<>() {
                private final javafx.scene.control.Button editBtn = new javafx.scene.control.Button("Edit");
                private final javafx.scene.control.Button deleteBtn = new javafx.scene.control.Button("Delete");

                {
                    editBtn.setOnAction(e -> openEditMedicine(getTableView().getItems().get(getIndex())));
                    deleteBtn.setOnAction(e -> deleteMedicine(getTableView().getItems().get(getIndex())));
                    editBtn.getStyleClass().add("btn-small");
                    deleteBtn.getStyleClass().add("btn-danger");
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        javafx.scene.layout.HBox box = new javafx.scene.layout.HBox(6, editBtn, deleteBtn);
                        setGraphic(box);
                    }
                }
            });
        } catch (SQLException e) {
            // TODO: Show error dialog
        }
        medicineSearchField.textProperty().addListener((obs, oldVal, newVal) -> searchMedicines(newVal));
    }

    private void searchMedicines(String query) {
        try {
            if (query == null || query.isBlank()) {
                medicineList.setAll(medicineService.listAll());
            } else {
                medicineList.setAll(medicineService.search(query));
            }
        } catch (SQLException e) {
            // TODO: Show error dialog
        }
    }

    @FXML
    private void closeDrawer() {
    }

    @FXML
    private void openAddBatch() {
    }

    @FXML
    private void editMedicineFromDrawer() {
        Medicine selected = getSelectedMedicine();
        if (selected != null) openEditMedicine(selected);
    }

    @FXML
    private void deleteMedicineFromDrawer() {
        Medicine selected = getSelectedMedicine();
        if (selected != null) deleteMedicine(selected);
    }

    private Medicine getSelectedMedicine() {
        return medicineTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void bulkDelete() {
    }
}
