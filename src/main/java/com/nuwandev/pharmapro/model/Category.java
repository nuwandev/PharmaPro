package com.nuwandev.pharmapro.model;

import java.time.OffsetDateTime;

public record Category(
        Long id,
        String name,
        String description,
        OffsetDateTime createdAt
) {
}
