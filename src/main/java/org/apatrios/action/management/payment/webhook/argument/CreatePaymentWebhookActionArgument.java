package org.apatrios.action.management.payment.webhook.argument;

import lombok.Builder;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;

@Builder
public record CreatePaymentWebhookActionArgument(String type, String event, YookassaPaymentDto object) {
}
