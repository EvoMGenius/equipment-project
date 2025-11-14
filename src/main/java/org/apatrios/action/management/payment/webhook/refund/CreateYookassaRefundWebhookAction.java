package org.apatrios.action.management.payment.webhook.refund;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.management.payment.webhook.common.argument.YookassaPaymentWebhookActionArgument;
import org.apatrios.action.management.payment.webhook.handler.YookassaWebhookHandler;
import org.apatrios.feign.dto.YookassaPaymentDto;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.service.management.payment.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateYookassaRefundWebhookAction implements YookassaWebhookHandler {

    private final PaymentService paymentService;

    @Override
    public List<String> getEventTypes() {
        return List.of("refund.succeeded",
                       "refund.canceled",
                       "refund.pending");
    }

    @Override
    @Transactional
    public void handle(@NonNull YookassaPaymentWebhookActionArgument argument) {
        YookassaPaymentDto dto = argument.getObject();
        paymentService.setStatusByExternalId(dto.getPaymentId(), mapYookassaStatus(dto.getStatus()));
    }

    private PaymentStatus mapYookassaStatus(String status) {
        return switch (status.toLowerCase()) {
            case "pending" -> PaymentStatus.REFUND_PENDING;
            case "succeeded" -> PaymentStatus.REFUND_SUCCEEDED;
            case "canceled" -> PaymentStatus.PAYMENT_CANCELED;
            default -> throw new IllegalStateException("Unknown YooKassa status: " + status);
        };
    }
}
