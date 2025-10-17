package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Franchisee;

@Value
@Builder
public class UpdateBikeArgument {

    ModelBike modelBike;

    Franchisee franchisee;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    Iot iot;

    BikeStatus status;

    String comment;
}
