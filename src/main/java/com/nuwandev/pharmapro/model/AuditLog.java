package com.nuwandev.pharmapro.model;

import java.time.OffsetDateTime;

public record AuditLog(
        Long id,
        Long actorUserId,
        String actionType,
        String entity,
        Long entityId,
        String details,
        OffsetDateTime createdAt
) {
}
