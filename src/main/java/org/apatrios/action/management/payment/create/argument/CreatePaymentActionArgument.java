package org.apatrios.action.management.payment.create.argument;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class CreatePaymentActionArgument {
    UUID paymentTypeId;
    UUID entityTypeId;
    String currency;
    BigDecimal amount;
    UUID statusId;
}
