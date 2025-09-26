package org.apatrios.controller.bike.internal.dto;

import lombok.*;
import org.apatrios.model.BikeStatus;
import org.apatrios.model.Iot;
import org.apatrios.model.dictoinary.ModelBike;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBikeDto {

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
