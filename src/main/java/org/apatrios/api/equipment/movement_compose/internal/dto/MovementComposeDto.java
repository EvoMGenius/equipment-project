package org.apatrios.api.equipment.movement_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.equipment.movement.internal.dto.MovementDto;

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
@Schema(description = "DTO состава передвижения")
public class MovementComposeDto {

    @Schema(description = "ID")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Передвижение")
    MovementDto movement;

    @Schema(description = "Идентификатор объекта (например, велосипеда или компонента)", example = "d4e5f6a7-8901-42bc-a1de-abcdef123456")
    UUID objectId;

    @Schema(description = "Количество объектов в составе перемещения", example = "10")
    Integer amount;

    @Schema(description = "Комментарий к записи состава перемещения", example = "Переданы вместе с запчастями")
    String note;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
