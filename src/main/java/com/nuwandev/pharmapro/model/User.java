package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.UserRole;
import com.nuwandev.pharmapro.enums.UserStatus;

import java.time.OffsetDateTime;

public record User(
        Long id,
        String username,
        String fullName,
        String email,
        String passwordHash,
        UserRole role,
        UserStatus status,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
