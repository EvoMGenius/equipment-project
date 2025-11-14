package org.apatrios.action.management.payment.provider;

import feign.FeignException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.management.payment.create.CreatePaymentActionArgument;
import org.apatrios.feign.PaymentClient;
import org.apatrios.feign.dto.CreateYookassaPaymentDto;
import org.apatrios.feign.dto.YookassaAmountDto;
import org.apatrios.feign.dto.YookassaConfirmationDto;
import org.apatrios.feign.dto.YookassaPaymentDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class YooKassaPaymentProvider implements PaymentProvider {

    private final PaymentClient paymentClient;

    @Override
    public String getProviderName() {
        return "yookassa";
    }

    @Override
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
    public ExternalPayment createExternalPayment(@NonNull String idempotencyKey, @NonNull CreatePaymentActionArgument argument) {
        YookassaPaymentDto yookassaPayment = paymentClient.createYookassaPayment(idempotencyKey, CreateYookassaPaymentDto.builder()
                                                                                                                         .capture(true)
                                                                                                                         .amount(YookassaAmountDto.builder()
                                                                                                                                                  .value(argument.getAmount().getValue())
                                                                                                                                                  .currency(argument.getAmount().getCurrency())
                                                                                                                                                  .build())
                                                                                                                         .confirmation(YookassaConfirmationDto.builder()
                                                                                                                                                              .type("redirect")
                                                                                                                                                              .returnUrl(argument.getReturnUrl())
                                                                                                                                                              .build())
                                                                                                                         .build());
        return ExternalPayment.builder()
                              .externalPaymentId(yookassaPayment.getId())
                              .confirmationUrl(yookassaPayment.getConfirmation().getConfirmationUrl())
                              .build();
    }
}