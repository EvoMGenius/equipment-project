package org.apatrios.service.management.telemetry.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchTelemetryArgument {
    Integer batteryMin;

    Integer batteryMax;

    String latitude;

    String longitude;
}
