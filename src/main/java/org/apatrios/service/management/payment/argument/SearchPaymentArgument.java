package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchPaymentArgument {
    BigDecimal value;
    String currency;
    BigDecimal incomeValue;
    String incomeCurrency;
    String returnUrl;
    String confirmationUrl;
    String searchString;
    UUID paymentTypeId;
    PaymentStatus status;
    UUID entityId;
    String entityType;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    Set<UUID> franchiseeIds;
}
