package org.apatrios.api.equipment.movement.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.point.dto.PointDto;
import org.apatrios.model.equipment.MovementStatus;
import org.apatrios.model.dictoinary.Point;

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
@Schema(description = "DTO передвижения")
public class MovementDto {

    @Schema(description = "Идентификатор перемещения", example = "a12f45c7-89d0-4b23-b1a7-1234567890ab")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Дата и время создания записи", example = "2025-09-27T14:30:00")
    LocalDateTime startDate;

    @Schema(description = "Точки отправления")
    PointDto pointFrom;

    @Schema(description = "Точки назначения")
    PointDto pointTo;

    @Schema(description = "Дата и время завершения перемещения", example = "2025-09-27T16:45:00")
    LocalDateTime dateEnd;

    @Schema(description = "Статус перемещения")
    MovementStatus status;

    @Schema(description = "Дополнительная заметка", example = "Доставлен в сервисный центр")
    String note;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
