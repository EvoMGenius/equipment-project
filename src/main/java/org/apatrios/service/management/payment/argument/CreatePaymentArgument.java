package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PaymentType;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreatePaymentArgument {
    Set<UUID> franchiseeIds;
    BigDecimal amount;
    String currency;
    PaymentType paymentType;
    UUID entityId;
    String entityType;
}
