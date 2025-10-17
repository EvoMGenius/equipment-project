package org.apatrios.api.equipment.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.model.equipment.OutfitStatus;
import org.apatrios.model.dictoinary.OutfitModel;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO экипировки")
public class OutfitDto {

    @Schema(description = "Уникальный идентификатор экипировки", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id;

    @Schema(description = "Модель экипировки")
    OutfitModelDto model;

    @Schema(description = "Инвентарный номер экипировки", example = "4521")
    Integer invNumber;

    @Schema(description = "Текущий статус экипировки", example = "AVAILABLE")
    OutfitStatus status;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;
}
