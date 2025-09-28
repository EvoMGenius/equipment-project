package org.apatrios.controller.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.OutfitStatus;
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

    @Schema(description = "Инвентарный номер экипировки")
    Integer invNumber;

    @Schema(description = "Текущий статус экипировки")
    OutfitStatus status;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;
}