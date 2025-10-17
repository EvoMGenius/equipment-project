package org.apatrios.api.equipment.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.OutfitStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска экипировки")
public class SearchOutfitDto {

    @Schema(description = "id Модели экипировки")
    UUID outfitModelId;

    @Schema(description = "id Франчизи")
    UUID franchiseeId;

    @Schema(description = "Текущий статус экипировки")
    OutfitStatus status;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;

    @Schema(description = "Дата создания начало")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания конец")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}