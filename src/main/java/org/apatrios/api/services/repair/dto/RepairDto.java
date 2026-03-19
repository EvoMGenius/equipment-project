package org.apatrios.api.services.repair.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.management.point.dto.PointDto;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO с полной информацией о ремонте")
public record RepairDto(

        @Schema(description = "ID записи ремонта")
        UUID id,

        @Schema(description = "Номер заявки на ремонт", example = "REP-2026-005")
        String number,

        @Schema(description = "Тип произведенного ремонта")
        String fixType,

        @Schema(description = "Проблема со слов клиента")
        String problem,

        @Schema(description = "Текущий статус ремонта")
        RepairStatus status,

        @Schema(description = "Дата и время создания заявки")
        LocalDateTime createDate,

        @Schema(description = "Сервисный центр (пункт)")
        PointDto point,

        @Schema(description = "Список прикрепленных фотографий")
        List<Photo> photos
) {}