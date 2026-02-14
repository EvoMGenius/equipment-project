package org.apatrios.action.management.payment.create;

import feign.FeignException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.action.management.payment.create.argument.CreatePaymentActionArgument;
import org.apatrios.feign.payment.PaymentClient;
import org.apatrios.feign.payment.dto.CreateYookassaPaymentDto;
import org.apatrios.feign.payment.dto.YookassaAmountDto;
import org.apatrios.feign.payment.dto.YookassaConfirmationDto;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.CreatePaymentArgument;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreatePaymentAction implements Action<CreatePaymentActionArgument, Payment> {

    private final PaymentService paymentService;
    private final StatusService statusService;
    private final DictService dictService;
    private final PaymentClient paymentClient;
    @Value("${app.payment.return-url}")
    private String returnUrl;

    // todo переделать под новое описание оплаты
    @Override
    public Payment execute(@NonNull CreatePaymentActionArgument argument) {
        Dict paymentType = dictService.getExisting(argument.getPaymentTypeId());
        Dict entityType = dictService.getExisting(argument.getEntityTypeId());
        Status status = statusService.getExisting(argument.getStatusId());

        Payment payment = paymentService.create(CreatePaymentArgument.builder()
                                                                     .paymentType(paymentType)
                                                                     .status(status)
                                                                     .amount(argument.getAmount())
                                                                     .entityType(entityType)
                                                                     .currency(argument.getCurrency())
                                                                     .build());

        String paymentUrl = createYookassaPayment(UUID.randomUUID().toString(), payment);

        return paymentService.update(payment.getId(), UpdatePaymentArgument.builder()
                                                                           .paymentUrl(paymentUrl)
                                                                           .build());
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
    public String createYookassaPayment(String idempotencyKey, Payment payment) {
        YookassaPaymentDto yookassaPayment = paymentClient.createYookassaPayment(idempotencyKey, CreateYookassaPaymentDto.builder()
                                                                                                                         .capture(true)
                                                                                                                         .amount(YookassaAmountDto.builder()
                                                                                                                                                  .value(payment.getAmount())
                                                                                                                                                  .currency(payment.getCurrency())
                                                                                                                                                  .build())
                                                                                                                         .confirmation(YookassaConfirmationDto.builder()
                                                                                                                                                              .type("redirect")
                                                                                                                                                              .returnUrl(returnUrl)
                                                                                                                                                              .build())
                                                                                                                         .metadata(Map.of("payment_id", payment.getId()))
                                                                                                                         .build());
        return yookassaPayment.getConfirmation().getConfirmationUrl();
    }
}