package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.MovementType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record StockMovement(
        Long id,
        Long batchId,
        MovementType movementType,
        BigDecimal qtyDelta,
        BigDecimal unitCost,
        String refType,
        Long refId,
        String note,
        Long createdBy,
        OffsetDateTime createdAt
) {
}
