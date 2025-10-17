package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.Staff;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.Request;

import java.time.LocalDateTime;

@Value
@Builder
public class CreateRentArgument {

    Client client;

    Staff staff;

    LocalDateTime rentStart;

    LocalDateTime rentEnd;

    String comment;

    Rent parentRent;

    Request parentRequest;

    Payment payment;
}
