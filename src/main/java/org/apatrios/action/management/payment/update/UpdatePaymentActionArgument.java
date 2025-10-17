package org.apatrios.action.management.payment.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class UpdatePaymentActionArgument {
    UUID id;

    PaymentStatus status;

    BigDecimal amount;

    String currency;

    UUID paymentTypeId;

    UUID entityId;

    String entityType;
}
