package org.apatrios.action.management.payment.create;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class CreatePaymentActionArgument {
    BigDecimal amount;

    String currency;

    UUID paymentTypeId;

    UUID entityId;

    String entityType;
}
