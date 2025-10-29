package org.apatrios.api.services.feedback.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.ServiceDictionary;

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
@Schema(description = "DTO для создания отзыва клиента")
public class CreateFeedbackDto {

    @NotNull
    @Min(1)
    @Max(5)
    @Schema(description = "Оценка от 1 до 5", example = "4", required = true)
    Integer rate;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotBlank
    @Schema(description = "Текст отзыва", example = "Все понравилось!", required = true)
    String note;

    @Schema(description = "Услуга ID", required = true)
    UUID serviceDictionaryId;
}
