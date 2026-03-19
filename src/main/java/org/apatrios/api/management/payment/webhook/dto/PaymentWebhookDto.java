package org.apatrios.api.management.payment.webhook.dto;

import org.apatrios.feign.payment.dto.YookassaPaymentDto;

public record PaymentWebhookDto(
        String type,
        String event,
        YookassaPaymentDto object
) {}
