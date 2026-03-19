package org.apatrios.api.management.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.PointStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Параметры фильтрации точек")
public record SearchPointDto(
        @Schema(description = "Поиск по названию (частичное совпадение)")
        String name,

        @Schema(description = "Поиск по адресу")
        String address,

        @Schema(description = "Фильтр по компании")
        UUID companyId,

        @Schema(description = "Фильтр по типу точки")
        UUID pointTypeId,

        @Schema(description = "Фильтр по статусу")
        PointStatus status,

        @Schema(description = "Показывать удаленные")
        Boolean isDeleted,

        @Schema(description = "Создана ОТ")
        LocalDateTime createDateFrom,

        @Schema(description = "Создана ДО")
        LocalDateTime createDateTo,

        @Schema(description = "Обновлено ОТ")
        LocalDateTime updateDateFrom,

        @Schema(description = "Обновлено ДО")
        LocalDateTime updateDateTo
) {}