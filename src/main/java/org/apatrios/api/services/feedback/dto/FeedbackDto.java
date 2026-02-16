package org.apatrios.api.services.feedback.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO отзыва клиента")
public class FeedbackDto {

    @Schema(description = "ID отзыва")
    UUID id;

    @Schema(description = "Тип сущности, к которой оставлен отзыв (Аренда, Точка и т.д.)")
    DictDto entityType;

    @Schema(description = "ID сущности, к которой оставлен отзыв")
    UUID parentEntityId;

    @Schema(description = "Текстовое описание отзыва", example = "Все понравилось, велосипед в отличном состоянии!")
    String description;

    @Schema(description = "Оценка от 1 до 5", example = "5")
    Integer evaluation;
}
