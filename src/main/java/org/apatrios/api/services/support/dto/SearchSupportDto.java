package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.SupportStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO поиска обращений")
public record SearchSupportDto(
        @Schema(description = "Тип обращения")
        String type,

        @Schema(description = "Статус тикета")
        SupportStatus status,

        @Schema(description = "Дата создания от")
        LocalDateTime createDateFrom,

        @Schema(description = "Описание")
        String description,

        @Schema(description = "ID родительского ремонта")
        UUID childRepairId,

        @Schema(description = "Дата создания до")
        LocalDateTime createDateTo
) {}