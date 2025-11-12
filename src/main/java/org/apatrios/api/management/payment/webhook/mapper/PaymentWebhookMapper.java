package org.apatrios.api.management.payment.webhook.mapper;

import org.apatrios.action.management.payment.webhook.common.argument.YookassaPaymentWebhookActionArgument;
import org.apatrios.api.management.payment.webhook.dto.YookassaPaymentWebhookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentWebhookMapper {
    PaymentWebhookMapper PAYMENT_WEBHOOK_MAPPER = Mappers.getMapper(PaymentWebhookMapper.class);

    YookassaPaymentWebhookActionArgument toArgument(YookassaPaymentWebhookDto dto);
}
