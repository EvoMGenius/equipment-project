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
@Schema(description = "DTO поиска отзывов")
public class SearchFeedbackDto {

    @Schema(description = "Фильтр по типу родительской сущности")
    UUID entityTypeId;

    @Schema(description = "Фильтр по конкретному ID родительской сущности")
    UUID parentEntityId;

    @Schema(description = "Текстовое описание отзыва", example = "Все понравилось, велосипед в отличном состоянии!")
    String description;

    @Schema(description = "Фильтр по оценке")
    Integer evaluation;
}