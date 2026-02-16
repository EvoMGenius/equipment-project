package org.apatrios.action.management.payment.webhook;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.payment.webhook.argument.CreatePaymentWebhookActionArgument;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreatePaymentWebhookAction implements VoidAction<CreatePaymentWebhookActionArgument> {

    private final PaymentService paymentService;

    @Transactional
    public void execute(@NonNull CreatePaymentWebhookActionArgument argument) {
        YookassaPaymentDto dto = argument.getObject();
        UUID paymentId = UUID.fromString(dto.getMetadata().get("payment_id").toString());

        paymentService.update(paymentId, UpdatePaymentArgument.builder()
                                                                    .status(mapStatusToCode(dto.getStatus()))
                                                                    .build());
    }

    private PaymentStatus mapStatusToCode(String status) {
        return switch (status) {
            case "succeeded" -> PaymentStatus.CREATED;
            case "canceled" -> PaymentStatus.CANCELED;
            case "waiting_for_capture" -> PaymentStatus.WAITING_FOR_CAPTURE;
            case "pending" -> PaymentStatus.PENDING;
            default -> PaymentStatus.ERROR;
        };
    }
}
