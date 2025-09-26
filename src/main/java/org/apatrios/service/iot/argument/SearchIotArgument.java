package org.apatrios.service.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.BikeStatus;
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