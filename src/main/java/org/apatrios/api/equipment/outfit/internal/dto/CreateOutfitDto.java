package org.apatrios.api.equipment.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO создания экипировки")
public class CreateOutfitDto {

    @NotNull
    @Schema(description = "id Модели экипировки")
    UUID outfitModelId;

    @NotNull
    @Schema(description = "Инвентарный номер экипировки")
    Integer invNumber;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;
}