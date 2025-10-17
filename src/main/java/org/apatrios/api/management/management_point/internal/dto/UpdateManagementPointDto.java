package org.apatrios.api.management.management_point.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.PointStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления информации о точке")
public class UpdateManagementPointDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @Schema(description = "Название точки", example = "Пункт выдачи №1", required = true)
    @NotBlank
    String name;

    @Schema(description = "Физический адрес точки", example = "г. Москва, ул. Ленина, 1", required = true)
    @NotBlank
    String address;

    @Schema(description = "ID Франчайзи, владеющий точкой", required = true)
    @NotNull
    UUID franchiseeId;

    @Schema(description = "ID Тип точки", required = true)
    @NotNull
    UUID pointTypeId;

    @Schema(description = "Статус точки", example = "ACTIVE", required = true)
    PointStatus status;

    @Schema(description = "Географическая широта", example = "55.7558", required = true)
    @NotNull
    Double latitude;

    @Schema(description = "Географическая долгота", example = "37.6173", required = true)
    @NotNull
    Double longitude;
}