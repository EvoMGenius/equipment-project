package org.apatrios.service.services.debt.argument;

import lombok.Builder;
import org.apatrios.model.management.Document;

import java.math.BigDecimal;

@Builder
public record CreateDebtArgument(
        String debtType,
        BigDecimal total,
        String description,
        Document document
) {
}
