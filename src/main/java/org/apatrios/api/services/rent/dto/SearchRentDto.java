package org.apatrios.api.services.rent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.RentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO для поиска и фильтрации аренды")
public record SearchRentDto(

        @Schema(description = "Номер договора аренды")
        String number,

        @Schema(description = "ID типа аренды")
        UUID rentTypeId,

        @Schema(description = "Статус аренды")
        RentStatus status,

        @Schema(description = "ID пользователя")
        UUID userId,

        @Schema(description = "ID велосипеда")
        UUID bikeId,

        @Schema(description = "ID точки выдачи")
        UUID pointId,

        @Schema(description = "Список ID задолженностей")
        List<UUID> debtIds,

        @Schema(description = "Дата и время начала аренды")
        LocalDateTime startDate,

        @Schema(description = "Дата и время окончания аренды")
        LocalDateTime endDate,

        @Schema(description = "Итоговая сумма аренды")
        Integer total,

        @Schema(description = "Текущее количество дней аренды")
        Integer currentDays,

        @Schema(description = "Количество дней просрочки")
        Integer delay,

        @Schema(description = "Стоимость просрочки")
        BigDecimal delayCost,

        @Schema(description = "Список ID экипировки")
        List<UUID> outfits,

        @Schema(description = "Список ID прикреплённых документов")
        List<UUID> documentIds,

        @Schema(description = "Строка полнотекстового поиска")
        String searchString,

        @Schema(description = "ID платежа")
        UUID paymentId
) {}