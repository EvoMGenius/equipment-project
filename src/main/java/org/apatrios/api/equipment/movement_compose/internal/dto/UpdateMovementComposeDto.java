package org.apatrios.api.equipment.movement_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обновления состава передвижения")
public class UpdateMovementComposeDto {

    @NotNull
    @Schema(description = "Идентификатор", example = "2f4e3b1a-7b2d-43d3-b8f7-92a7d5c5e123")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Идентификатор перемещения", example = "c1f2a3b4-5678-49ab-90cd-1234567890ef")
    UUID movementId;

    @NotNull
    @Schema(description = "Идентификатор объекта (например, велосипеда или компонента)", example = "d4e5f6a7-8901-42bc-a1de-abcdef123456")
    UUID objectId;

    @NotNull
    @Schema(description = "Количество объектов в составе перемещения", example = "10")
    Integer amount;

    @Schema(description = "Комментарий к записи состава перемещения", example = "Переданы вместе с запчастями")
    String note;
}
