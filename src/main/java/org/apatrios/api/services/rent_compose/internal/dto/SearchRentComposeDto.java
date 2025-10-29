package org.apatrios.api.services.rent_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * DTO для поиска состава аренды
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска состава аренды")
public class SearchRentComposeDto {

    @Schema(description = "ID аренды", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID rentId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Количество объектов в аренде", example = "3")
    Integer amount;

    @Schema(description = "ID велосипеда, экипировки или запчасти", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @Schema(description = "Дата создания от", example = "2025-10-01T00:00:00")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания до", example = "2025-10-05T23:59:59")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления от", example = "2025-10-02T00:00:00")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления до", example = "2025-10-06T23:59:59")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
