package org.apatrios.api.services.feedback.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO поиска отзывов")
public record SearchFeedbackDto (

    @Schema(description = "Фильтр по типу родительской сущности")
    UUID entityTypeId,

    @Schema(description = "Фильтр по конкретному ID родительской сущности")
    UUID parentEntityId,

    @Schema(description = "Текстовое описание отзыва")
    String description,

    @Schema(description = "Фильтр по оценке")
    Integer evaluation
){}