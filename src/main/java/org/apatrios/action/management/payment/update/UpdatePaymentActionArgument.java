package org.apatrios.action.management.payment.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Amount;
import org.apatrios.model.management.IncomeAmount;
import org.apatrios.model.management.PaymentStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdatePaymentActionArgument {
    UUID id;
    Amount amount;
    IncomeAmount incomeAmount;
    String returnUrl;
    PaymentStatus status;
    UUID paymentTypeId;
    UUID entityId;
    String entityType;
    Set<UUID> franchiseeIds;
}
