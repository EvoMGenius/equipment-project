package org.apatrios.api.management.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.PointStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "Запрос на создание новой точки")
public record CreatePointDto(
        @Schema(description = "Название точки", required = true)
        @NotBlank
        String name,

        @Schema(description = "Адрес точки", required = true)
        @NotBlank
        String address,

        @Schema(description = "ID компании", required = true)
        @NotNull
        UUID companyId,

        @Schema(description = "ID типа точки", required = true)
        @NotNull
        UUID pointTypeId,

        @Schema(description = "Начальный статус", required = true)
        @NotNull
        PointStatus status,

        @Schema(description = "Широта")
        Double latitude,

        @Schema(description = "Долгота")
        Double longitude
) {}