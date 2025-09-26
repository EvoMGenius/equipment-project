package org.apatrios.controller.iot.internal.dto;

import lombok.*;
import org.apatrios.controller.sim.internal.dto.SimDto;
import org.apatrios.model.BikeStatus;
import org.apatrios.model.dictoinary.IotModel;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IotDto {
    private UUID id;
    private IotModel model;
    private String invNumber;
    private SimDto sim;
    private BikeStatus status;
    private String comment;
}