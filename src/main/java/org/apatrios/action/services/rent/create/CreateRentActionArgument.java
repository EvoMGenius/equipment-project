package org.apatrios.action.services.rent.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class CreateRentActionArgument {
    UUID clientId;

    UUID staffId;

    LocalDateTime rentStart;

    LocalDateTime rentEnd;

    String comment;

    UUID parentRentId;

    UUID parentRequestId;

    UUID paymentId;
}
