package org.apatrios.service.services.debt.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class SearchDebtArgument {
    UUID debtTypeId;

    BigDecimal total;

    String description;

    DebtStatus status;

    UUID documentId;

    String searchString;
}
