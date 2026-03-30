package com.nuwandev.pharmapro.model;

import java.time.OffsetDateTime;

public record Customer(
        Long id, String name, String phone, String email, String notes, OffsetDateTime createdAt) {
}
