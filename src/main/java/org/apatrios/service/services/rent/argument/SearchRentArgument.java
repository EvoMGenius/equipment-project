package org.apatrios.service.services.rent.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.model.services.RentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchRentArgument {

    UUID staffId;

    LocalDateTime rentStart;

    LocalDateTime rentEnd;

    RentStatus rentStatus;

    UUID clientId;

    UUID paymentId;

    String comment;

    UUID parentRentId;

    UUID parentRequestId;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
