package org.apatrios.action.management.payment.webhook.create;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.management.payment.webhook.common.argument.YookassaPaymentWebhookActionArgument;
import org.apatrios.action.management.payment.webhook.handler.YookassaWebhookHandler;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;
import org.apatrios.model.management.IncomeAmount;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.service.management.payment.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateYookassaPaymentWebhookAction implements YookassaWebhookHandler {

    private final PaymentService paymentService;

    @Override
    public List<String> getEventTypes() {
        return List.of("payment.succeeded",
                       "payment.canceled",
                       "payment.pending");
    }

    @Override
    @Transactional
    public void handle(@NonNull YookassaPaymentWebhookActionArgument argument) {
        YookassaPaymentDto dto = argument.getObject();
        paymentService.setStatusByExternalId(dto.getId(), mapYookassaStatus(dto.getStatus()));
        paymentService.setIncomeAmountByExternalId(dto.getId(), extractIncomeAmount(dto));
    }

    private IncomeAmount extractIncomeAmount(YookassaPaymentDto dto) {
        return IncomeAmount.builder()
                           .value(dto.getIncomeAmount().getValue())
                           .currency(dto.getIncomeAmount().getCurrency())
                           .build();
    }

    private PaymentStatus mapYookassaStatus(String status) {
        return switch (status.toLowerCase()) {
            case "pending" -> PaymentStatus.PAYMENT_PENDING;
            case "succeeded" -> PaymentStatus.PAYMENT_SUCCEEDED;
            case "canceled" -> PaymentStatus.PAYMENT_CANCELED;
            default -> throw new IllegalStateException("Unknown YooKassa status: " + status);
        };
    }
}
