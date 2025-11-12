package org.apatrios.action.management.payment.webhook.common.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.feign.dto.YookassaPaymentDto;

@Value
@Builder
public class YookassaPaymentWebhookActionArgument {
    String type;
    String event;
    YookassaPaymentDto object;
}
