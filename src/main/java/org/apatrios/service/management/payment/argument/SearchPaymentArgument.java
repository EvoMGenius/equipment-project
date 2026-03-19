package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SearchPaymentArgument(
        UUID companyId,
        UUID paymentTypeId,
        String currency,
        BigDecimal amountFrom,
        BigDecimal amountTo,
        UUID entityId,
        String entityType,
        PaymentStatus status,
        Boolean isDeleted,
        LocalDateTime dateOfDemandFrom,
        LocalDateTime dateOfDemandTo,
        LocalDateTime createDateFrom,
        LocalDateTime createDateTo,
        LocalDateTime updateDateFrom,
        LocalDateTime updateDateTo
) {
}
