package org.apatrios.service.equipment.bike.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Tariff;
import org.apatrios.model.management.Telemetry;

import java.util.List;

@Value
@Builder
public class CreateBikeArgument {
    String invNumber;

    ModelBike modelBike;

    Telemetry telemetry;

    List<Tariff> tariff;

    Tariff chosenTariff;

    Boolean isBlocked;

    Boolean isAlarmOn;

    Boolean isHeadlightsOn;
}
