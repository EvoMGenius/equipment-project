package org.apatrios.action.equipment.bike.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateBikeActionArgument {

    UUID iotId;

    UUID modelBikeId;

    Integer seqNumber;

    Integer invNumber;

    String vin;

    String motorWheel;

    String comment;
}

