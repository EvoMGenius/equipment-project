package org.apatrios.action.management.payment.create;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.action.management.payment.provider.ExternalPayment;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.CreatePaymentArgument;
import org.apatrios.action.management.payment.provider.PaymentProvider;
import org.apatrios.action.management.payment.provider.PaymentProviderFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreatePaymentAction implements Action<CreatePaymentActionArgument, Payment> {

    private final PaymentService paymentService;
    private final PaymentTypeService paymentTypeService;
    private final PaymentProviderFactory providerFactory;

    @Override
    @Transactional
    public Payment execute(@NonNull CreatePaymentActionArgument argument) {
        PaymentType paymentType = paymentTypeService.getExisting(argument.getPaymentTypeId());
        String idempotencyKey = UUID.randomUUID().toString();

        PaymentProvider provider = providerFactory.getProvider(paymentType.getName());
        ExternalPayment externalPayment = provider.createExternalPayment(idempotencyKey, argument);

        return paymentService.create(CreatePaymentArgument.builder()
                                                          .externalPaymentId(externalPayment.getExternalPaymentId())
                                                          .paymentType(paymentType)
                                                          .amount(argument.getAmount())
                                                          .returnUrl(argument.getReturnUrl())
                                                          .entityId(argument.getEntityId())
                                                          .entityType(argument.getEntityType())
                                                          .franchiseeIds(argument.getFranchiseeIds())
                                                          .confirmationUrl(externalPayment.getConfirmationUrl())
                                                          .build());
    }
}