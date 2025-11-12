package org.apatrios.api.management.payment.webhook;

import lombok.RequiredArgsConstructor;
import org.apatrios.action.management.payment.webhook.handler.YookassaWebhookHandlerFactory;
import org.apatrios.api.management.payment.webhook.dto.YookassaPaymentWebhookDto;
import org.springframework.web.bind.annotation.*;

import static org.apatrios.api.management.payment.webhook.mapper.PaymentWebhookMapper.PAYMENT_WEBHOOK_MAPPER;

@RestController
@RequestMapping("/webhook/payment")
@RequiredArgsConstructor
public class PaymentWebhookController {

    private final YookassaWebhookHandlerFactory yookassaWebhookHandlerFactory;

    @PostMapping("/yookassa")
    public void handleYookassaWebhook(@RequestBody YookassaPaymentWebhookDto dto) {
        yookassaWebhookHandlerFactory.getHandler(dto.getEvent()).handle(PAYMENT_WEBHOOK_MAPPER.toArgument(dto));
    }
}
