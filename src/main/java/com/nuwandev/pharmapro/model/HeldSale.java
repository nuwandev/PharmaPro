package com.nuwandev.pharmapro.model;

import java.time.OffsetDateTime;

public record HeldSale(
        Long id,
        String saleNumber,
        Long userId,
        String itemsJson,
        String notes,
        OffsetDateTime createdAt) {
}
