package org.apatrios.api.equipment.outfit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.outfit_model.dto.OutfitModelDto;
import org.apatrios.api.management.franchisee.internal.dto.FranchiseeDto;
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
@Schema(description = "DTO экипировки")
public class OutfitDto {

    @Schema(description = "Уникальный идентификатор экипировки", example = "123e4567-e89b-12d3-a456-426614174000")
    UUID id;

    @Schema(description = "Модель экипировки")
    OutfitModelDto model;

    @Schema(description = "Франчизи")
    FranchiseeDto franchisee;

    @Schema(description = "Текущий статус экипировки", example = "AVAILABLE")
    OutfitStatus status;

    @Schema(description = "Комментарий", example = "Выдана на сезонное использование")
    String comment;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
