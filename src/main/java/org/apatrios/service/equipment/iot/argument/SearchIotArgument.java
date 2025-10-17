package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.IotStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchIotArgument {
    UUID modelId;
    String invNumber;
    UUID simId;
    IotStatus status;
    String comment;
    String imei;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
}