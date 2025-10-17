package org.apatrios.api.management.management_point.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Schema(description = "DTO для создания новой точки")
public class CreateManagementPointDto {

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

    @Schema(description = "Географическая широта", example = "55.7558", required = true)
    @NotNull
    Double latitude;

    @Schema(description = "Географическая долгота", example = "37.6173", required = true)
    @NotNull
    Double longitude;
}
