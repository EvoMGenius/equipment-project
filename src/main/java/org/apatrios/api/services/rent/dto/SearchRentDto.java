package org.apatrios.api.services.rent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска и фильтрации аренды")
public class SearchRentDto {

    @Schema(description = "Поиск по номеру договора")
    String number;

    @Schema(description = "Фильтр по статусу")
    UUID statusId;

    @Schema(description = "Фильтр по пользователю")
    UUID userId;

    @Schema(description = "Фильтр по байку")
    UUID bikeId;

    @Schema(description = "Фильтр по точке выдачи")
    UUID pointId;

    @Schema(description = "Фильтр: активные на указанную дату")
    LocalDateTime activeAt;

    @Schema(description = "Фильтр: только с просрочкой")
    Boolean hasDelay;
}