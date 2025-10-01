package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;
import java.util.UUID;

@Value
@Builder
public class SearchIotArgument {
    UUID modelId;
    String invNumber;
    UUID simId;
    BikeStatus status;
    String comment;
}