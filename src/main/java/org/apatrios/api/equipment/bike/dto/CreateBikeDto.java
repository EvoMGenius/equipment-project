package org.apatrios.api.equipment.bike.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "DTO для создания велосипеда")
public record CreateBikeDto(
        @NotNull
        @Schema(description = "Идентификатор модели", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID modelBikeId,

        @NotNull
        @Schema(description = "Инвентарный номер", example = "12345")
        Integer invNumber,

        @NotNull
        @Schema(description = "Порядковый номер модели")
        Integer seqNumber,

        @NotBlank
        @Schema(description = "VIN номер электровелосипеда")
        String vin,

        @NotBlank
        @Schema(description = "Номер мотор-колеса")
        String motorWheel,

        @NotNull
        @Schema(description = "Идентификатор компании")
        UUID companyId,

        @NotNull
        @Schema(description = "Идентификатор IOT-модуля")
        UUID iotId,

        @Schema(description = "Комментарий")
        String comment
) {}