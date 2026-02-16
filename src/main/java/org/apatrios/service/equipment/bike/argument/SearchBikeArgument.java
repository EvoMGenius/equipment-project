package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.BikeStatus;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class SearchBikeArgument {
    String invNumber;

    UUID modelBikeId;

    UUID telemetryId;

    Boolean isBlocked;

    Boolean isAlarmOn;

    Boolean isHeadlightsOn;

    List<UUID> tariffIds;

    UUID chosenTariffId;

    BikeStatus status;
}
