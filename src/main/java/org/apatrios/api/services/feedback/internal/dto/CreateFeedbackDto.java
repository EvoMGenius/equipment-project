package org.apatrios.api.services.feedback.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания отзыва клиента")
public class CreateFeedbackDto {

    @NotNull
    @Min(1)
    @Max(5)
    @Schema(description = "Оценка от 1 до 5", example = "4", required = true)
    Integer rate;

    @NotBlank
    @Schema(description = "Текст отзыва", example = "Все понравилось!", required = true)
    String note;
}
