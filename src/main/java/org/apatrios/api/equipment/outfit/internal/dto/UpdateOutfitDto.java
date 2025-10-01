package org.apatrios.api.equipment.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.OutfitStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO обновления экипировки")
public class UpdateOutfitDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор экипировки", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id;

    @NotNull
    @Schema(description = "id Модели экипировки")
    UUID outfitModelId;

    @NotNull
    @Schema(description = "Инвентарный номер экипировки")
    Integer invNumber;

    @NotBlank
    @Schema(description = "Текущий статус экипировки")
    OutfitStatus status;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;
}