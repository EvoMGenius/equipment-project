package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.dictoinary.ModelBike;

@Value
@Builder
public class CreateBikeArgument {

    ModelBike modelBike;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    Iot iot;

    String comment;
}
