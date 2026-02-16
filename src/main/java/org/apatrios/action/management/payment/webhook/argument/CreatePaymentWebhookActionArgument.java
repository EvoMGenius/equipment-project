package org.apatrios.action.management.payment.webhook.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;

@Value
@Builder
public class CreatePaymentWebhookActionArgument {
    String type;
    String event;
    YookassaPaymentDto object;
}
