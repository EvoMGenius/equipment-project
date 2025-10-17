package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class UpdatePaymentArgument {
    BigDecimal amount;

    String currency;

    PaymentType paymentType;

    UUID entityId;

    String entityType;

    PaymentStatus status;
}
