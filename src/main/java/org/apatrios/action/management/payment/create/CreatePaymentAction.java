package org.apatrios.action.management.payment.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.CreatePaymentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreatePaymentAction implements Action<CreatePaymentActionArgument, Payment> {

    PaymentService paymentService;
    PaymentTypeService paymentTypeService;

    @Override
    @Transactional
    public Payment execute(@NonNull CreatePaymentActionArgument argument) {
        PaymentType paymentType = paymentTypeService.getExisting(argument.getPaymentTypeId());

        return paymentService.create(CreatePaymentArgument.builder()
                                                          .paymentType(paymentType)
                                                          .amount(argument.getAmount())
                                                          .currency(argument.getCurrency())
                                                          .entityId(argument.getEntityId())
                                                          .entityType(argument.getEntityType())
                                                          .franchiseeIds(argument.getFranchiseeIds())
                                                          .build());
    }
}
