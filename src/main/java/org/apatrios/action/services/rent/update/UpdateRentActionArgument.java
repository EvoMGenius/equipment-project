package org.apatrios.action.services.rent.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class UpdateRentActionArgument {
    UUID id;

    UUID clientId;

    UUID staffId;

    LocalDateTime rentStart;

    LocalDateTime rentEnd;

    String comment;

    UUID parentRentId;

    UUID parentRequestId;

    UUID paymentId;

    RentStatus rentStatus;

    UUID partnerId;

    UUID tariffId;
}
