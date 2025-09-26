package org.apatrios.controller.bike.internal.dto;

import lombok.*;
import org.apatrios.model.BikeStatus;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchBikeDto {
    UUID modelBikeId;

    //Порядковый номер внутри модели
    Integer seqNumber;

    // Инвентарный номер
    Integer invNumber;

    String vin;

    String motorWheel;

    UUID iotId;

    BikeStatus status;

    String comment;
}
