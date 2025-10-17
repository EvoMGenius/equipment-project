package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchBikeArgument {
    UUID modelBikeId;

    UUID franchiseeId;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    UUID iotId;

    BikeStatus status;

    String comment;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
