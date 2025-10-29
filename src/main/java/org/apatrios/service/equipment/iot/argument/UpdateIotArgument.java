package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.IotStatus;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.IotModel;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateIotArgument {
    IotModel model;
    String invNumber;
    Sim sim;
    IotStatus status;
    String comment;
    String imei;
    Set<UUID> franchiseeIds;
}