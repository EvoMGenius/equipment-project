package org.apatrios.api.management.telemetry.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO с информацией о телеметрии устройства")
public class TelemetryDto {
    @Schema(description = "Идентификатор записи")
    UUID id;

    @Schema(description = "Уровень заряда батареи (0-100)")
    Integer battery;

    @Schema(description = "Широта (Latitude)")
    String latitude;

    @Schema(description = "Долгота (Longitude)")
    String longitude;
}