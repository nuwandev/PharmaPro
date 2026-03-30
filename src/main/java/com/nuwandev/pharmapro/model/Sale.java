package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.PaymentMethod;
import com.nuwandev.pharmapro.enums.SaleStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Sale(
        Long id,
        String saleNumber,
        Long customerId,
        Long userId,
        BigDecimal subtotal,
        BigDecimal taxAmount,
        BigDecimal discountPercent,
        BigDecimal discountAmount,
        BigDecimal grandTotal,
        PaymentMethod paymentMethod,
        BigDecimal cashTendered,
        BigDecimal changeAmount,
        String cardReference,
        String notes,
        SaleStatus status,
        OffsetDateTime createdAt) {
}
