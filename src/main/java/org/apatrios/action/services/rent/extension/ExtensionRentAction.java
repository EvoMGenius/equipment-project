package org.apatrios.action.services.rent.extension;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.action.management.payment.create.argument.CreatePaymentActionArgument;
import org.apatrios.model.management.Payment;
import org.apatrios.model.services.Rent;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent.argument.CreateRentArgument;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExtensionRentAction implements Action<UUID, Rent> {

    private final RentService rentService;
    private final Action<CreatePaymentActionArgument, Payment> createPaymentAction;

    @Override
    public Rent execute(@NonNull UUID id) {
        Rent oldRent = rentService.closeRent(id);

        Payment payment = createPayment(oldRent);

        return rentService.create(CreateRentArgument.builder()
                                                    .rentType(oldRent.getRentType())
                                                    .bike(oldRent.getBike())
                                                    .point(oldRent.getPoint())
                                                    .currentDays(oldRent.getDelay())
                                                    .debts(oldRent.getDebts())
                                                    .delay(oldRent.getDelay())
                                                    .delayCost(oldRent.getDelayCost())
                                                    .total(oldRent.getTotal())
                                                    .documents(oldRent.getDocuments())
                                                    .number(oldRent.getNumber())
                                                    .outfits(oldRent.getOutfits())
                                                    .user(oldRent.getUser())
                                                    .payment(payment)
                                                    .build());
    }

    private Payment createPayment(Rent rent) {
        return createPaymentAction.execute(CreatePaymentActionArgument.builder()
                                                                      .amount(rent.getPayment().getAmount())
                                                                      .currency(rent.getPayment().getCurrency())
                                                                      .paymentTypeId(rent.getPayment().getPaymentType().getId())
                                                                      .entityTypeId(rent.getPayment().getEntityType().getId())
                                                                      .build());
    }
}
