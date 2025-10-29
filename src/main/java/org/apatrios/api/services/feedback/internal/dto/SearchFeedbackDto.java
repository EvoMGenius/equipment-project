package org.apatrios.api.services.feedback.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Schema(description = "DTO поиска отзывов")
public class SearchFeedbackDto {

    @Schema(description = "Оценка отзыва (точное значение)", example = "5")
    Integer rate;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Поиск по тексту отзыва", example = "Очень понравилось обслуживание")
    String note;

    @Schema(description = "Дата создания (с)", example = "2025-01-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания (по)", example = "2025-01-31T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления (с)", example = "2025-02-01T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления (по)", example = "2025-02-28T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;

    @Schema(description = "Услуга ID")
    UUID serviceDictionaryId;
}
