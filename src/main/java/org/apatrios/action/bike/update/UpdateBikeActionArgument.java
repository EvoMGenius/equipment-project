package org.apatrios.action.bike.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.BikeStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateBikeActionArgument {

    UUID modelBikeId;

    UUID id;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    UUID iotId;

    BikeStatus status;

    String comment;
}
