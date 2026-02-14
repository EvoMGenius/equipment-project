package org.apatrios.api.services.feedback.dto;

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
@Schema(description = "DTO для создания отзыва клиента")
public class CreateFeedbackDto {

    @Schema(description = "ID типа родительской сущности из справочника Dict")
    UUID entityTypeId;

    @Schema(description = "ID родительской сущности (например, ID аренды)")
    UUID parentEntityId;

    @Schema(description = "Текст отзыва")
    String description;

    @Schema(description = "Оценка от 1 до 5")
    Integer evaluation;
}