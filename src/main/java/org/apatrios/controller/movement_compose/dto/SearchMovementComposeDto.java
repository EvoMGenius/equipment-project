package org.apatrios.controller.movement_compose.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска состава передвижения")
public class SearchMovementComposeDto {

    @Schema(description = "Идентификатор перемещения", example = "c1f2a3b4-5678-49ab-90cd-1234567890ef")
    UUID movementId;

    @Schema(description = "Идентификатор объекта (например, велосипеда или компонента)", example = "d4e5f6a7-8901-42bc-a1de-abcdef123456")
    UUID objectId;

    @Schema(description = "Количество объектов в составе перемещения", example = "10")
    Integer amount;

    @Schema(description = "Комментарий к записи состава перемещения", example = "Переданы вместе с запчастями")
    String note;
}
