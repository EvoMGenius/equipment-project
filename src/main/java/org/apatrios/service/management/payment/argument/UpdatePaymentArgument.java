package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Company;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Builder
public record UpdatePaymentArgument(
        Company company,
        PaymentType paymentType,
        String currency,
        BigDecimal amount,
        UUID entityId,
        String entityType,
        LocalDateTime dateOfDemand,
        PaymentStatus status,
        Map<String, String> metadata
) {
}
