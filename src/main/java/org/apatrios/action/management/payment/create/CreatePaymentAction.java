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
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Company;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.management.company.CompanyService;
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
    private final PaymentTypeService paymentTypeService;
    private final CompanyService companyService;
    private final PaymentClient paymentClient;
    @Value("${app.host}")
    private String appHost;

    @Override
    public Payment execute(@NonNull CreatePaymentActionArgument argument) {
        PaymentType paymentType = paymentTypeService.getExisting(argument.paymentTypeId());
        Company company = companyService.getExisting(argument.companyId());

        Payment payment = paymentService.create(CreatePaymentArgument.builder()
                                                                     .paymentType(paymentType)
                                                                     .amount(argument.amount())
                                                                     .entityType(argument.entityType())
                                                                     .entityId(argument.entityId())
                                                                     .currency(argument.currency())
                                                                     .company(company)
                                                                     .build());

        YookassaPaymentDto yookassaPayment = createYookassaPayment(payment.getId().toString(), argument);

        return paymentService.update(payment.getId(), UpdatePaymentArgument.builder()
                                                                           .metadata(Map.of("confirm_url", yookassaPayment.confirmation().confirmationUrl()))
                                                                           .build());
    }

    private YookassaPaymentDto createYookassaPayment(String paymentId, CreatePaymentActionArgument argument) {
        return paymentClient.createYookassaPayment(paymentId, CreateYookassaPaymentDto.builder()
                                                                                      .capture(true)
                                                                                      .amount(YookassaAmountDto.builder()
                                                                                                               .value(argument.amount())
                                                                                                               .currency(argument.currency())
                                                                                                               .build())
                                                                                      .confirmation(YookassaConfirmationDto.builder()
                                                                                                                           .type("redirect")
                                                                                                                           .returnUrl(appHost)
                                                                                                                           .build())
                                                                                      .metadata(Map.of("payment_id", paymentId))
                                                                                      .build());
    }
}