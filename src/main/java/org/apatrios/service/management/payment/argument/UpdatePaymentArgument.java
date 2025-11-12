package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Amount;
import org.apatrios.model.management.IncomeAmount;
import org.apatrios.model.management.PaymentStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdatePaymentArgument {
    PaymentType paymentType;
    UUID entityId;
    String entityType;
    PaymentStatus status;
    Set<UUID> franchiseeIds;
    Amount amount;
    IncomeAmount incomeAmount;
    String returnUrl;
}
