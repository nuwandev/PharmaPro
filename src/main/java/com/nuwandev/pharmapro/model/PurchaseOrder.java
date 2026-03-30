package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public record PurchaseOrder(
        Long id,
        String poNumber,
        Long supplierId,
        PurchaseOrderStatus status,
        LocalDate expectedDeliveryDate,
        String notes,
        BigDecimal subtotal,
        BigDecimal taxAmount,
        BigDecimal grandTotal,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        OffsetDateTime receivedAt) {
}
