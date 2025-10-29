package org.apatrios.action.equipment.iot.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateIotActionArgument {
    UUID iotModelId;
    String invNumber;
    UUID simId;
    String comment;
    String imei;
    Set<UUID> franchiseeIds;
}
