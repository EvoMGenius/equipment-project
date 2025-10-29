package org.apatrios.api.services.feedback.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
@Schema(description = "DTO для обновления отзыва клиента")
public class UpdateFeedbackDto {

    @NotNull
    @Schema(description = "Идентификатор отзыва", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Min(1)
    @Max(5)
    @Schema(description = "Оценка от 1 до 5", example = "3", required = true)
    Integer rate;

    @NotBlank
    @Schema(description = "Текст отзыва", example = "Хорошо, но есть нюансы", required = true)
    String note;

    @Schema(description = "Услуга ID", required = true)
    UUID serviceDictionaryId;
}
