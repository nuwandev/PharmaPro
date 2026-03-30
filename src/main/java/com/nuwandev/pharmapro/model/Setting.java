package com.nuwandev.pharmapro.model;

import java.time.OffsetDateTime;

public record Setting(String key, String value, OffsetDateTime updatedAt) {
}
