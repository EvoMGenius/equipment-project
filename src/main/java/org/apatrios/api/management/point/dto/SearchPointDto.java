package org.apatrios.api.management.point.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
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
@Schema(description = "DTO для поиска информации о точке")
public class SearchPointDto {
    @Schema(description = "Идентификатор типа точки из справочника Dict (Парковка, Склад и т.д.)")
    UUID pointTypeId;

    @Schema(description = "Наименование новой точки", example = "Парковка Северная-1")
    String name;

    @Schema(description = "Контактный номер телефона для связи с точкой")
    String number;

    @Schema(description = "Полный физический адрес")
    String address;

    @Schema(description = "График работы в текстовом формате")
    String workTime;

    @Schema(description = "Текущий статус точки (Активна, Временно закрыта, Ремонт)")
    PointStatus status;
}
