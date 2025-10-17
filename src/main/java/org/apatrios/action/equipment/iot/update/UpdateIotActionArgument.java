package org.apatrios.action.equipment.iot.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.IotStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateIotActionArgument {
    UUID id;
    UUID iotModelId;
    String invNumber;
    UUID simId;
    IotStatus status;
    String comment;
    String imei;
}
