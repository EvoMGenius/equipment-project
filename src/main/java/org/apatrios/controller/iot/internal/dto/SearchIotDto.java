package org.apatrios.controller.iot.internal.dto;

import lombok.*;
import org.apatrios.model.BikeStatus;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchIotDto {
    private UUID modelId;
    private String invNumber;
    private UUID simId;
    private BikeStatus status;
    private String comment;
}