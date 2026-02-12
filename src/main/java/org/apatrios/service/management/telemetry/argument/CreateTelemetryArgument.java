package org.apatrios.service.management.telemetry.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateTelemetryArgument {
    Integer battery;

    String latitude;

    String longitude;
}
