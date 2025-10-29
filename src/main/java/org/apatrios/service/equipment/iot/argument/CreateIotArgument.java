package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.IotModel;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateIotArgument {
    IotModel model;
    String invNumber;
    Sim sim;
    String comment;
    String imei;
    Set<UUID> franchiseeIds;
}