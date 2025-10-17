package org.apatrios.action.services.rent.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.Staff;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.Request;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent.argument.CreateRentArgument;
import org.apatrios.service.services.request.RequestService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateRentAction implements Action<CreateRentActionArgument, Rent> {

    ClientService clientService;
    StaffService staffService;
    RentService rentService;
    RequestService requestService;
    PaymentService paymentService;

    @Override
    @Transactional
    public Rent execute(@NonNull CreateRentActionArgument argument) {
        Client client = clientService.getExisting(argument.getClientId());
        Staff staff = staffService.getExisting(argument.getStaffId());
        Rent parentRent = rentService.getExisting(argument.getParentRentId());
        Request request = requestService.getExisting(argument.getParentRequestId());
        Payment payment = paymentService.getExisting(argument.getPaymentId());

        return rentService.create(CreateRentArgument.builder()
                                                    .parentRent(parentRent)
                                                    .parentRequest(request)
                                                    .client(client)
                                                    .staff(staff)
                                                    .rentStart(argument.getRentStart())
                                                    .rentEnd(argument.getRentEnd())
                                                    .comment(argument.getComment())
                                                    .payment(payment)
                                                    .build());
    }
}
