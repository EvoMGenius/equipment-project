package org.apatrios.action.services.rent.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Staff;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.Request;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.rent.RentService;
import org.apatrios.service.services.rent.argument.UpdateRentArgument;
import org.apatrios.service.services.request.RequestService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateRentAction implements Action<UpdateRentActionArgument, Rent> {

    ClientService clientService;
    StaffService staffService;
    RentService rentService;
    RequestService requestService;

    @Override
    @Transactional
    public Rent execute(@NonNull UpdateRentActionArgument argument) {
        Client client = clientService.getExisting(argument.getClientId());
        Staff staff = staffService.getExisting(argument.getStaffId());
        Rent parentRent = rentService.getExisting(argument.getParentRentId());
        Request request = requestService.getExisting(argument.getParentRequestId());

        return rentService.update(argument.getId(),
                                  UpdateRentArgument.builder()
                                                    .parentRent(parentRent)
                                                    .parentRequest(request)
                                                    .client(client)
                                                    .staff(staff)
                                                    .rentStart(argument.getRentStart())
                                                    .rentEnd(argument.getRentEnd())
                                                    .comment(argument.getComment())
                                                    .paymentStatus(argument.getPaymentStatus())
                                                    .rentStatus(argument.getRentStatus())
                                                    .build());
    }
}
