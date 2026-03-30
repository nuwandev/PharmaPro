package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.MedicineStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Medicine(
        Long id,
        String name,
        String brand,
        Long categoryId,
        String unit,
        String barcode,
        MedicineStatus status,
        String description,
        BigDecimal defaultPurchasePrice,
        BigDecimal defaultSellPrice,
        int reorderLevel,
        BigDecimal taxRate,
        boolean requiresPrescription,
        boolean allowFractionalQty,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
