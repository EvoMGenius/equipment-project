package org.apatrios.service.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.BikeStatus;
import org.apatrios.model.Iot;
import org.apatrios.model.dictoinary.ModelBike;

@Value
@Builder
public class CreateBikeArgument {

    ModelBike modelBike;

    //Порядковый номер внутри модели
    Integer seqNumber;

    // Инвентарный номер
    Integer invNumber;

    String vin;

    String motorWheel;

    Iot iot;

    BikeStatus status;

    String comment;
}
