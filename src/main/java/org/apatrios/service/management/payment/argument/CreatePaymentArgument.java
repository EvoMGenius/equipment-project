package org.apatrios.service.management.payment.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Amount;
import org.apatrios.model.management.IncomeAmount;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreatePaymentArgument {
    Set<UUID> franchiseeIds;
    Amount amount;
    IncomeAmount incomeAmount;
    String returnUrl;
    String confirmationUrl;
    String externalPaymentId;
    PaymentType paymentType;
    UUID entityId;
    String entityType;
}
