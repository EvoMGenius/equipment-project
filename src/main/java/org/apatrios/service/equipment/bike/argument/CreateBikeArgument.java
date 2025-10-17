package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Franchisee;

@Value
@Builder
public class CreateBikeArgument {

    ModelBike modelBike;

    Franchisee franchisee;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    Iot iot;

    String comment;
}
