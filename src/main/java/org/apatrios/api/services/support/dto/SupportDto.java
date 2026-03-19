package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.services.repair.dto.RepairDto;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.SupportStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO обращения в поддержку")
public record SupportDto(
        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Дата создания")
        LocalDateTime createDate,

        @Schema(description = "Тип обращения")
        String type,

        @Schema(description = "Описание проблемы")
        String description,

        @Schema(description = "Список фото")
        List<Photo> photo,

        @Schema(description = "Связанный ремонт (если есть)")
        RepairDto childRepair,

        @Schema(description = "Статус тикета")
        SupportStatus status
) {}