package org.apatrios.api.equipment.outfit.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO создания экипировки")
public record CreateOutfitDto(
        @NotBlank
        @Schema(description = "Имя")
        String name,

        @NotNull
        @Schema(description = "Тарифы")
        List<UUID> tariffIds,

        @NotNull
        @Schema(description = "Выбранный тариф")
        UUID chosenTariffId
) {}