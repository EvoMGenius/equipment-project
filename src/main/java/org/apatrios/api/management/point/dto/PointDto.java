package org.apatrios.api.management.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.point_type.dto.PointTypeDto;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.model.management.PointStatus;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Информация о точке")
public record PointDto(
        @Schema(description = "ID точки")
        UUID id,

        @Schema(description = "Название точки")
        String name,

        @Schema(description = "Физический адрес")
        String address,

        @Schema(description = "Компания")
        CompanyDto company,

        @Schema(description = "тип точки (из справочника)")
        PointTypeDto pointType,

        @Schema(description = "Текущий статус")
        PointStatus status,

        @Schema(description = "Широта", example = "55.7558")
        Double latitude,

        @Schema(description = "Долгота", example = "37.6173")
        Double longitude,

        @Schema(description = "Дата создания")
        LocalDateTime createDate,

        @Schema(description = "Признак удаления")
        Boolean isDeleted
) {}