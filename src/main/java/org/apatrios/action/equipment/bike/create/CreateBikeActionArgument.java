package org.apatrios.action.equipment.bike.create;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CreateBikeActionArgument {
    String invNumber;

    UUID modelBikeId;

    UUID telemetryId;

    List<UUID> tariffIds;

    UUID chosenTariffId;

    UUID statusId;

    Boolean isBlocked;

    Boolean isAlarmOn;

    Boolean isHeadlightsOn;
}

