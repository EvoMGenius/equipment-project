package org.apatrios.action.management.payment.refund.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Amount;

import java.util.UUID;

@Value
@Builder
public class CreateYookassaRefundActionArgument {
    UUID paymentId;
    Amount amount;
}
