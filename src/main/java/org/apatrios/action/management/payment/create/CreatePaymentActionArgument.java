package org.apatrios.action.management.payment.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Amount;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreatePaymentActionArgument {
    Amount amount;
    String returnUrl;
    UUID paymentTypeId;
    UUID entityId;
    String entityType;
    Set<UUID> franchiseeIds;
}
