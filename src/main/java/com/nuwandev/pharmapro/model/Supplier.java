package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.SupplierStatus;

import java.time.OffsetDateTime;

public record Supplier(
        Long id,
        String name,
        String contactPerson,
        String phone,
        String email,
        String website,
        String address,
        String taxNumber,
        String paymentTerms,
        SupplierStatus status,
        boolean isPreferred,
        String notes,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
