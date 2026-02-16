package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class SearchPaymentArgument {
    UUID paymentTypeId;

    UUID entityTypeId;

    String currency;

    BigDecimal amount;

    PaymentStatus status;
}
