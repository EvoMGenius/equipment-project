package org.apatrios.action.management.payment.create.argument;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record CreatePaymentActionArgument(
        UUID companyId,
        UUID paymentTypeId,
        String currency,
        BigDecimal amount,
        UUID entityId,
        String entityType,
        LocalDateTime dateOfDemand
) {
}
