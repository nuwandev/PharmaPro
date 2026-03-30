package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.BatchStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public record Batch(
        Long id,
        Long medicineId,
        String batchNumber,
        BigDecimal quantityOnHand,
        BigDecimal purchasePrice,
        BigDecimal sellPrice,
        LocalDate manufactureDate,
        LocalDate expiryDate,
        Long supplierId,
        String storageLocation,
        String notes,
        BatchStatus status,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
