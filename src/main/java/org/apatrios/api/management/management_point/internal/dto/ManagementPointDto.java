package org.apatrios.api.management.management_point.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.PointStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для информации о точке")
public class ManagementPointDto {

    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Название точки", example = "Пункт выдачи №1", required = true)
    String name;

    @Schema(description = "Физический адрес точки", example = "г. Москва, ул. Ленина, 1", required = true)
    String address;

    @Schema(description = "Франчайзи, владеющий точкой")
    Franchisee franchisee;

    @Schema(description = "Тип точки", required = true)
    PointType pointType;

    @Schema(description = "Статус точки", example = "ACTIVE", required = true)
    PointStatus status;

    @Schema(description = "Географическая широта", example = "55.7558", required = true)
    Double latitude;

    @Schema(description = "Географическая долгота", example = "37.6173", required = true)
    Double longitude;

    @Schema(description = "Дата и время создания", example = "2025-10-01T12:34:56")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления", example = "2025-10-02T09:15:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
