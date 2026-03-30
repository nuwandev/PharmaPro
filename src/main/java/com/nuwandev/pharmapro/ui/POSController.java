package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class POSController {
    @FXML
    private BorderPane posRoot;
    @FXML
    private HBox posTopBar;
    @FXML
    private Label saleNumberLabel;
    @FXML
    private Label cashierNameLabel;
    @FXML
    private Label posDateTimeLabel;
    @FXML
    private Button voidSaleBtn;
    @FXML
    private TextField productSearchField;
    @FXML
    private ProgressIndicator searchSpinner;
    @FXML
    private Spinner<?> quickQtySpinner;
    @FXML
    private Button addToCartBtn;
    @FXML
    private ListView<?> searchResultsList;
    @FXML
    private TableView<?> cartTable;
    @FXML
    private TableColumn<?, ?> cartIndexCol;
    @FXML
    private TableColumn<?, ?> cartMedicineCol;
    @FXML
    private TableColumn<?, ?> cartBatchCol;
    @FXML
    private TableColumn<?, ?> cartExpiryCol;
    @FXML
    private TableColumn<?, ?> cartQtyCol;
    @FXML
    private TableColumn<?, ?> cartUnitPriceCol;
    @FXML
    private TableColumn<?, ?> cartDiscountCol;
    @FXML
    private TableColumn<?, ?> cartLineTotalCol;
    @FXML
    private TableColumn<?, ?> cartRemoveCol;
    @FXML
    private HBox cartFooter;
    @FXML
    private Button clearCartBtn;
    @FXML
    private Button holdSaleBtn;
    @FXML
    private Button recallSaleBtn;
    @FXML
    private Label cartSubtotalQuickLabel;
    @FXML
    private VBox paymentPanel;
    @FXML
    private Label subtotalLabel;
    @FXML
    private Label taxLabel;
    @FXML
    private TextField discountPercentField;
    @FXML
    private Label discountValueLabel;
    @FXML
    private Label grandTotalLabel;
    @FXML
    private TextField customerSearchField;
    @FXML
    private Button walkInBtn;
    @FXML
    private ComboBox<?> paymentMethodCombo;
    @FXML
    private VBox cashPaymentSection;
    @FXML
    private TextField cashTenderedField;
    @FXML
    private Button cash10Btn;
    @FXML
    private Button cash20Btn;
    @FXML
    private Button cash50Btn;
    @FXML
    private Button cashExactBtn;
    @FXML
    private Label changeLabel;
    @FXML
    private VBox cardPaymentSection;
    @FXML
    private TextField cardReferenceField;
    @FXML
    private TextArea saleNotesField;
    @FXML
    private Button completeSaleBtn;
    @FXML
    private StackPane receiptOverlay;
    @FXML
    private VBox receiptCard;
    @FXML
    private Label receiptSaleNumber;
    @FXML
    private Label receiptTotal;
    @FXML
    private Button printReceiptBtn;
    @FXML
    private Button newSaleBtn;

    @FXML
    private void voidSale() {
    }

    @FXML
    private void handleSearchKeyRelease() {
    }

    @FXML
    private void addToCart() {
    }

    @FXML
    private void selectSearchResult() {
    }

    @FXML
    private void clearCart() {
    }

    @FXML
    private void holdSale() {
    }

    @FXML
    private void recallHeldSale() {
    }

    @FXML
    private void setWalkInCustomer() {
    }

    @FXML
    private void quickCash() {
    }

    @FXML
    private void completeSale() {
    }

    @FXML
    private void printReceipt() {
    }

    @FXML
    private void startNewSale() {
    }
}
