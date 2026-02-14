package org.apatrios.service.services.debt.argument;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class SearchDebtArgument {
    UUID debtTypeId;

    BigDecimal total;

    String description;

    UUID statusId;

    UUID documentId;

    String searchString;
}
