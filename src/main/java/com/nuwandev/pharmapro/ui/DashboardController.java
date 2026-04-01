package com.nuwandev.pharmapro.ui;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {
    @FXML
    private ScrollPane dashboardScrollPane;
    @FXML
    private VBox dashboardRoot;
    @FXML
    private HBox kpiRow;
    @FXML
    private HBox kpiTotalMedicines;
    @FXML
    private HBox kpiLowStock;
    @FXML
    private HBox kpiExpiringSoon;
    @FXML
    private HBox kpiTodaySales;
    @FXML
    private Label kpiTotalMedicinesValue;
    @FXML
    private Label kpiTotalMedicinesSub;
    @FXML
    private Label kpiLowStockValue;
    @FXML
    private Label kpiLowStockSub;
    @FXML
    private Label kpiExpiringSoonValue;
    @FXML
    private Label kpiExpiringSoonSub;
    @FXML
    private Label kpiTodaySalesValue;
    @FXML
    private Label kpiTodaySalesSub;
    @FXML
    private VBox salesChartCard;
    @FXML
    private ComboBox<?> chartRangeSelector;
    @FXML
    private AreaChart<?, ?> salesAreaChart;
    @FXML
    private CategoryAxis salesChartXAxis;
    @FXML
    private NumberAxis salesChartYAxis;
    @FXML
    private VBox expiringTableCard;
    @FXML
    private TableView<?> expiringTable;
    @FXML
    private TableColumn<?, ?> expiryMedicineCol;
    @FXML
    private TableColumn<?, ?> expiryBatchCol;
    @FXML
    private TableColumn<?, ?> expiryQtyCol;
    @FXML
    private TableColumn<?, ?> expiryDateCol;
    @FXML
    private TableColumn<?, ?> expiryDaysLeftCol;
    @FXML
    private TableColumn<?, ?> expiryStatusCol;
    @FXML
    private VBox lowStockTableCard;
    @FXML
    private TableView<?> lowStockTable;
    @FXML
    private TableColumn<?, ?> lowStockMedicineCol;
    @FXML
    private TableColumn<?, ?> lowStockCategoryCol;
    @FXML
    private TableColumn<?, ?> lowStockCurrentQtyCol;
    @FXML
    private TableColumn<?, ?> lowStockReorderLvlCol;
    @FXML
    private TableColumn<?, ?> lowStockStatusCol;
    @FXML
    private VBox recentSalesCard;
    @FXML
    private TableView<?> recentSalesTable;
    @FXML
    private TableColumn<?, ?> saleReceiptCol;
    @FXML
    private TableColumn<?, ?> saleDateTimeCol;
    @FXML
    private TableColumn<?, ?> saleCashierCol;
    @FXML
    private TableColumn<?, ?> saleItemsCol;
    @FXML
    private TableColumn<?, ?> saleTotalCol;
    @FXML
    private TableColumn<?, ?> salePaymentMethodCol;
    @FXML
    private TableColumn<?, ?> saleStatusCol;
    @FXML
    private Label monthlyRevenueValue;
    @FXML
    private Label revenueTrendIcon;
    @FXML
    private Label revenueTrendValue;
    @FXML
    private Label todayTransactionCount;
    @FXML
    private Label todayTransactionSub;
    @FXML
    private ProgressBar stockHealthBar;
    @FXML
    private Label stockHealthLabel;
    @FXML
    private Button viewAllExpiringBtn;
    @FXML
    private Button viewAllLowStockBtn;
    @FXML
    private Button viewAllSalesBtn;

    @FXML
    private void viewAllExpiring() {
        // Handle view all expiring
    }

    @FXML
    private void viewAllLowStock() {
        // Handle view all low stock
    }

    @FXML
    private void viewAllSales() {
        // Handle view all sales
    }
}
