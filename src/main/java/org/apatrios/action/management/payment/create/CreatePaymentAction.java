package org.apatrios.action.management.payment.create;

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
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.dictionary.PurchaseTypeService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.CreatePaymentArgument;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CreatePaymentAction implements Action<CreatePaymentActionArgument, Payment> {

    private final PaymentService paymentService;
    private final PurchaseTypeService purchaseTypeService;
    private final DictService dictService;
    private final PaymentClient paymentClient;
    @Value("${app.payment.return-url}")
    private String returnUrl;

    @Override
    public Payment execute(@NonNull CreatePaymentActionArgument argument) {
        PurchaseType paymentType = purchaseTypeService.getExisting(argument.getPaymentTypeId());
        Dict entityType = dictService.getExisting(argument.getEntityTypeId());

        Payment payment = paymentService.create(CreatePaymentArgument.builder()
                                                                     .paymentType(paymentType)
                                                                     .amount(argument.getAmount())
                                                                     .entityType(entityType)
                                                                     .currency(argument.getCurrency())
                                                                     .build());

        YookassaPaymentDto yookassaPayment = createYookassaPayment(payment.getId().toString(), argument);

        return paymentService.update(payment.getId(), UpdatePaymentArgument.builder()
                                                                           .metadata(Map.of("external_payment_id", yookassaPayment.getId(),
                                                                                            "confirm_url", yookassaPayment.getConfirmation().getConfirmationUrl()))
                                                                           .build());
    }

    private YookassaPaymentDto createYookassaPayment(String paymentId, CreatePaymentActionArgument argument) {
        return paymentClient.createYookassaPayment(paymentId, CreateYookassaPaymentDto.builder()
                                                                                      .capture(true)
                                                                                      .amount(YookassaAmountDto.builder()
                                                                                                               .value(argument.getAmount())
                                                                                                               .currency(argument.getCurrency())
                                                                                                               .build())
                                                                                      .confirmation(YookassaConfirmationDto.builder()
                                                                                                                           .type("redirect")
                                                                                                                           .returnUrl(returnUrl)
                                                                                                                           .build())
                                                                                      .metadata(Map.of("payment_id", paymentId))
                                                                                      .build());
    }
}