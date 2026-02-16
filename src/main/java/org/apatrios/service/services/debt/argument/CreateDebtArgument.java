package org.apatrios.service.services.debt.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.management.Document;
import org.apatrios.model.services.DebtStatus;

import java.math.BigDecimal;

@Value
@Builder
public class CreateDebtArgument {
    Dict debtType;

    BigDecimal total;

    String description;

    Document document;
}
