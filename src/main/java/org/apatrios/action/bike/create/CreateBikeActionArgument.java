package org.apatrios.action.bike.create;

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

