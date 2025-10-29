package org.apatrios.api.services.feedback.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.service_dictionary.dto.ServiceDictionaryDto;

import java.time.LocalDateTime;
import java.util.Set;
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

    @Schema(description = "Идентификатор отзыва", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Оценка от 1 до 5", example = "5")
    Integer rate;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Текст отзыва", example = "Очень понравилось обслуживание!")
    String note;

    @Schema(description = "Дата и время создания", example = "2025-02-01T12:30:00")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления", example = "2025-02-05T14:10:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "Услуга")
    ServiceDictionaryDto serviceDictionary;
}
