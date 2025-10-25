package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Partner;
import org.apatrios.model.dictoinary.Tariff;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.model.management.Staff;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.RentStatus;
import org.apatrios.model.services.Request;

import java.time.LocalDateTime;

@Value
@Builder
public class UpdateRentArgument {
    Client client;

    Staff staff;

    LocalDateTime rentStart;

    LocalDateTime rentEnd;

    String comment;

    Rent parentRent;

    Request parentRequest;

    Payment payment;

    RentStatus rentStatus;

    Partner partner;

    Tariff tariff;
}
