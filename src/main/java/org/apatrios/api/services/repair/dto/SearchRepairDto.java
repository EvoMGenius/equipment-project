package org.apatrios.api.services.repair.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска заявок на ремонт")
public class SearchRepairDto {

    @Schema(description = "Поиск по номеру заявки")
    String number;

    @Schema(description = "Фильтр по статусу")
    UUID statusId;

    @Schema(description = "Фильтр по типу ремонта")
    UUID fixTypeId;

    @Schema(description = "Фильтр по сервисному центру")
    UUID pointId;

    @Schema(description = "Фильтр по дате создания (С)")
    LocalDateTime createDateFrom;

    @Schema(description = "Фильтр по дате создания (ПО)")
    LocalDateTime createDateTo;
}