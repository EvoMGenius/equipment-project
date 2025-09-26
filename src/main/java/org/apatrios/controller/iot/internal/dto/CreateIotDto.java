package org.apatrios.controller.iot.internal.dto;

import lombok.*;
import org.apatrios.model.BikeStatus;
import org.apatrios.model.Sim;
import org.apatrios.model.dictoinary.IotModel;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateIotDto {
    private IotModel model;
    private String invNumber;
    private Sim sim;
    private BikeStatus status;
    private String comment;
}