package org.apatrios.api.equipment.movement.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.MovementStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска передвижения")
public class SearchMovementDto {

    @Schema(description = "Дата завершения перемещения начало")
    LocalDateTime dateEndFrom;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Дата завершения перемещения конец")
    LocalDateTime dateEndTo;

    @Schema(description = "Дата создания записи начало")
    LocalDateTime startDateFrom;

    @Schema(description = "Дата создания записи конец")
    LocalDateTime startDateTo;

    @Schema(description = "Идентификатор точки отправления", example = "1e3b45f6-67d8-4c2b-b9d1-7890abcdef12")
    UUID pointFromId;

    @Schema(description = "Идентификатор точки назначения", example = "4a6c89d1-23f7-45b8-9cde-23456789abcd")
    UUID pointToId;

    @Schema(description = "Статус перемещения")
    MovementStatus status;

    @Schema(description = "Дополнительная заметка", example = "Доставлен в сервисный центр")
    String note;

    @Schema(description = "Дата создания начало")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания конец")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
