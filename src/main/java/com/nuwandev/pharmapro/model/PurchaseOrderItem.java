package com.nuwandev.pharmapro.model;

import java.math.BigDecimal;

public record PurchaseOrderItem(
        Long id,
        Long purchaseOrderId,
        Long medicineId,
        String unit,
        BigDecimal qtyOrdered,
        BigDecimal qtyReceived,
        BigDecimal unitCost,
        BigDecimal subtotal) {
}
