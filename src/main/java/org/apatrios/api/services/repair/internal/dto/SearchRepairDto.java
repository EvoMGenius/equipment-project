package org.apatrios.api.services.repair.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска ремонта")
public class SearchRepairDto {

    @Schema(description = "ID объекта (велосипед, экипировка или запчасть)", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @Schema(description = "ID типа ремонта", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID repairTypeId;

    @Schema(description = "ID исполнителя", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID staffId;

    @Schema(description = "Описание выполненных работ", example = "Замена тормозных колодок")
    String description;

    @Schema(description = "Статус ремонта", example = "IN_PROGRESS")
    RepairStatus status;

    @Schema(description = "Дата создания ремонта", example = "2025-10-01T10:00:00")
    LocalDateTime createDate;

    @Schema(description = "Дата окончания ремонта", example = "2025-10-02T15:30:00")
    LocalDateTime dateEnd;

    @Schema(description = "Начало диапазона для фильтрации по дате обновления", example = "2025-10-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Конец диапазона для фильтрации по дате обновления", example = "2025-10-02T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления записи", example = "false")
    boolean isDeleted;

    @Schema(description = "Комментарий к ремонту", example = "Срочный ремонт по просьбе клиента")
    String comment;
}
