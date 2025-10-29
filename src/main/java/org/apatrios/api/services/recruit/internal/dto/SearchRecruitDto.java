package org.apatrios.api.services.recruit.internal.dto;

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
@Schema(description = "DTO поиска записей о назначенных услугах")
public class SearchRecruitDto {

    @Schema(description = "ID клиента", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID clientId;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

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
}
