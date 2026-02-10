package org.apatrios.action.management.payment.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.management.Payment;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdatePaymentAction implements Action<UpdatePaymentActionArgument, Payment> {

    PaymentService paymentService;
    PaymentTypeService paymentTypeService;

    @Override
    @Transactional
    public Payment execute(@NonNull UpdatePaymentActionArgument argument) {
        PaymentType paymentType = paymentTypeService.getExisting(argument.getPaymentTypeId());

        return paymentService.update(argument.getId(),
                                     UpdatePaymentArgument.builder()
                                                          .paymentType(paymentType)
                                                          .amount(argument.getAmount())
                                                          .incomeAmount(argument.getIncomeAmount())
                                                          .returnUrl(argument.getReturnUrl())
                                                          .entityId(argument.getEntityId())
                                                          .entityType(argument.getEntityType())
                                                          .status(argument.getStatus())
                                                          .franchiseeIds(argument.getFranchiseeIds())
                                                          .build());
    }
}
