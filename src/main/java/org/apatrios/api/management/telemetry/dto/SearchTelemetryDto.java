package org.apatrios.api.management.telemetry.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "Параметры поиска телеметрии")
public class SearchTelemetryDto {
    @Schema(description = "Минимальный порог заряда батареи", example = "10")
    Integer batteryMin;

    @Schema(description = "Максимальный порог заряда батареи", example = "90")
    Integer batteryMax;

    @Schema(description = "Фильтр по широте (частичное совпадение)")
    String latitude;

    @Schema(description = "Фильтр по долготе (частичное совпадение)")
    String longitude;
}