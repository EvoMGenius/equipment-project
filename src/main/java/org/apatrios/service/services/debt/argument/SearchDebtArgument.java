package org.apatrios.service.services.debt.argument;

import lombok.Builder;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record SearchDebtArgument(
        String debtType,
        BigDecimal total,
        String description,
        DebtStatus status,
        UUID documentId,
        String searchString
) {
}