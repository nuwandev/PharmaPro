package com.nuwandev.pharmapro.model;

import java.math.BigDecimal;

public record SaleItem(
        Long id,
        Long saleId,
        Long medicineId,
        Long batchId,
        BigDecimal quantity,
        BigDecimal unitPrice,
        BigDecimal discountPercent,
        BigDecimal lineTotal) {
}
