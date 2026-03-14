package org.apatrios.api.services.feedback.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO отзыва клиента")
public record FeedbackDto(

        @Schema(description = "ID отзыва")
        UUID id,

        @Schema(description = "Тип к которой оставлен отзыв (Аренда, Точка и т.д.)")
        String entityType,

        @Schema(description = "ID сущности, к которой оставлен отзыв")
        UUID parentEntityId,

        @Schema(description = "Текстовое описание отзыва", example = "Все понравилось, велосипед в отличном состоянии!")
        String description,

        @Schema(description = "Оценка от 1 до 5", example = "5")
        Integer evaluation
) {}