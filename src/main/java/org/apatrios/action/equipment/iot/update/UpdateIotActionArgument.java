package org.apatrios.action.equipment.iot.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateIotActionArgument {
    UUID id;
    UUID iotModelId;
    String invNumber;
    UUID simId;
    BikeStatus status;
    String comment;
}
