package com.nuwandev.pharmapro.model;

import com.nuwandev.pharmapro.enums.AlertMethod;

public record ReorderRule(
        Long id, Long categoryId, int reorderLevel, int reorderQty, AlertMethod alertMethod) {
}
