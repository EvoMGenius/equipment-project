package org.apatrios.service.equipment.iot.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.dictoinary.IotModel;

@Value
@Builder
public class UpdateIotArgument {
    IotModel model;
    String invNumber;
    Sim sim;
    BikeStatus status;
    String comment;
}