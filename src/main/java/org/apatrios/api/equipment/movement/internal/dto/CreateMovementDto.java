package org.apatrios.api.equipment.movement.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
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
@Schema(description = "DTO создания передвижения")
public class CreateMovementDto {

    @NotNull
    @Schema(description = "Идентификатор точки отправления", example = "1e3b45f6-67d8-4c2b-b9d1-7890abcdef12")
    UUID pointFromId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Идентификатор точки назначения", example = "4a6c89d1-23f7-45b8-9cde-23456789abcd")
    UUID pointToId;

    @Schema(description = "Дата и время завершения перемещения", example = "2025-09-27T16:45:00")
    LocalDateTime dateEnd;

    @Schema(description = "Дополнительная заметка", example = "Доставлен в сервисный центр")
    String note;
}
