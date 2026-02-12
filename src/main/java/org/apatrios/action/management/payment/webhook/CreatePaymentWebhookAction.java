package org.apatrios.action.management.payment.webhook;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.payment.webhook.argument.CreatePaymentWebhookActionArgument;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;
import org.apatrios.model.equipment.Status;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreatePaymentWebhookAction implements VoidAction<CreatePaymentWebhookActionArgument> {

    private final PaymentService paymentService;
    private final StatusService statusService;

    @Transactional
    public void execute(@NonNull CreatePaymentWebhookActionArgument argument) {
        YookassaPaymentDto dto = argument.getObject();
        UUID paymentId = (UUID) dto.getMetadata().get("payment_id");
        Status status = statusService.getByCode(mapStatusToCode(dto.getStatus()));

        paymentService.update(paymentId, UpdatePaymentArgument.builder()
                                                              .status(status)
                                                              .build());
    }

    private String mapStatusToCode(String status) {
        return switch (status) {
            case "succeeded" -> "SUCCESS";
            case "canceled" -> "CANCELED";
            case "waiting_for_capture" -> "PENDING";
            default -> "ERROR";
        };
    }
}
