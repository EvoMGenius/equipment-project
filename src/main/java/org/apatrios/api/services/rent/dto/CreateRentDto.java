package org.apatrios.api.services.rent.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO для инициации новой аренды")
public record CreateRentDto(

        @NotNull
        @Schema(description = "ID пользователя")
        UUID userId,

        @NotNull
        @Schema(description = "ID велосипеда")
        UUID bikeId,

        @NotNull
        @Schema(description = "ID точки выдачи")
        UUID pointId,

        @NotNull
        @Schema(description = "Список ID выбранной экипировки")
        List<UUID> outfitIds,

        @NotBlank
        @Schema(description = "Номер договора аренды")
        String number,

        @NotNull
        @Schema(description = "Список ID задолженностей пользователя")
        List<UUID> debtIds,

        @NotNull
        @Schema(description = "Итоговая сумма аренды")
        Integer total,

        @NotNull
        @Schema(description = "Текущее количество дней аренды")
        Integer currentDays,

        @NotNull
        @Schema(description = "Количество дней просрочки")
        Integer delay,

        @NotNull
        @Schema(description = "Стоимость просрочки")
        BigDecimal delayCost,

        @NotNull
        @Schema(description = "Список ID прикреплённых документов")
        List<UUID> documentIds,

        @NotNull
        @Schema(description = "ID типа аренды")
        UUID rentTypeId
) {}