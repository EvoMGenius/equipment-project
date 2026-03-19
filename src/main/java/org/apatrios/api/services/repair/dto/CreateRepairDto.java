package org.apatrios.api.services.repair.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "DTO для создания новой заявки на ремонт")
public record CreateRepairDto(

        @NotBlank
        @Schema(description = "тип ремонта")
        String fixType,

        @NotBlank
        @Schema(description = "Описание проблемы")
        String problem,

        @NotNull
        @Schema(description = "ID сервисного центра (Point)")
        UUID pointId
) {}