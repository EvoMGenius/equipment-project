package org.apatrios.api.services.feedback.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Schema(description = "DTO для создания отзыва клиента")
public record CreateFeedbackDto(

        @NotNull
        @Schema(description = "ID типа родительской сущности из справочника Dict")
        UUID entityTypeId,

        @NotNull
        @Schema(description = "ID родительской сущности (например, ID аренды)")
        UUID parentEntityId,

        @NotBlank
        @Schema(description = "Текст отзыва")
        String description,

        @NotNull
        @Schema(description = "Оценка от 1 до 5")
        Integer evaluation
) {}