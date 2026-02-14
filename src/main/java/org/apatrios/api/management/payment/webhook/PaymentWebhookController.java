package org.apatrios.api.management.payment.webhook;

import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.payment.webhook.argument.CreatePaymentWebhookActionArgument;
import org.apatrios.api.management.payment.webhook.dto.PaymentWebhookDto;
import org.apatrios.config.yookassa.YookassaWebhookIpChecker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

import static org.apatrios.api.management.payment.webhook.mapper.PaymentWebhookMapper.PAYMENT_WEBHOOK_MAPPER;

@RestController
@RequestMapping("/webhook/payment")
@RequiredArgsConstructor
public class PaymentWebhookController {

    private final VoidAction<CreatePaymentWebhookActionArgument> createPaymentWebhookAction;
    private final YookassaWebhookIpChecker yookassaWebhookIpChecker;

    @PostMapping("/yookassa")
    public void handleYookassaWebhook(HttpServletRequest request, @RequestBody PaymentWebhookDto dto) {
        if (!yookassaWebhookIpChecker.isValidRequest(request)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid webhook IP");
        createPaymentWebhookAction.execute(PAYMENT_WEBHOOK_MAPPER.toArgument(dto));
    }
}
