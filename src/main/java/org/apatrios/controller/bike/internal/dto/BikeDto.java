package org.apatrios.controller.bike.internal.dto;

import lombok.*;
import org.apatrios.controller.iot.internal.dto.IotDto;
import org.apatrios.model.BikeStatus;
import org.apatrios.model.dictoinary.ModelBike;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeDto {
    private UUID id;

    private ModelBike modelBike;

    private Integer seqNumber;

    private Integer invNumber;

    private String vin;

    private String motorWheel;

    private IotDto iot;

    private BikeStatus status;

    private String comment;
}
