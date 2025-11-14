package org.apatrios.action.management.payment.refund;

import feign.FeignException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.payment.refund.argument.CreateYookassaRefundActionArgument;
import org.apatrios.feign.PaymentClient;
import org.apatrios.feign.dto.CreateYookassaRefundDto;
import org.apatrios.feign.dto.YookassaAmountDto;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.service.management.payment.PaymentService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateYookassaRefundAction implements VoidAction<CreateYookassaRefundActionArgument> {

    private final PaymentService paymentService;
    private final PaymentClient paymentClient;

    @Override
    @Transactional
    public void execute(@NonNull CreateYookassaRefundActionArgument argument) {
        String idempotencyKey = UUID.randomUUID().toString();
        Payment payment = paymentService.getExisting(argument.getPaymentId());
        createRefund(idempotencyKey, payment);
        paymentService.setStatusByExternalId(payment.getExternalPaymentId(), PaymentStatus.REFUND_PENDING);
    }

    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 2),
            include = {
                    FeignException.InternalServerError.class,
                    FeignException.BadGateway.class,
                    FeignException.ServiceUnavailable.class,
                    FeignException.GatewayTimeout.class
            }
    )
    private void createRefund(String idempotencyKey, Payment payment) {
        if (payment.getStatus().equals(PaymentStatus.REFUND_SUCCEEDED)) return;
        paymentClient.createYookassaRefund(idempotencyKey, CreateYookassaRefundDto.builder()
                                                                                  .paymentId(payment.getExternalPaymentId())
                                                                                  .amount(YookassaAmountDto.builder()
                                                                                                           .value(payment.getAmount().getValue())
                                                                                                           .currency(payment.getAmount().getCurrency())
                                                                                                           .build())
                                                                                  .build());
    }
}
