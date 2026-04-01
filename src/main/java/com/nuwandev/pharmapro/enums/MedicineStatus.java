package com.nuwandev.pharmapro.enums;

import java.util.Locale;

public enum MedicineStatus {
    ACTIVE,
    INACTIVE;

    public static MedicineStatus fromDbValue(String value) {
        if (value == null || value.isBlank()) {
            return ACTIVE;
        }
        return MedicineStatus.valueOf(value.trim().toUpperCase(Locale.ROOT));
    }
}
