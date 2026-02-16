package org.apatrios.api.equipment.outfit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.OutfitStatus;

import java.util.List;
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
    @Schema(description = "Поиск по наименованию экипировки (частичное совпадение)")
    String name;

    @Schema(description = "Фильтр по списку доступных тарифов")
    List<UUID> tariffIds;

    @Schema(description = "Фильтр по выбранному тарифу")
    UUID chosenTariffId;

    @Schema(description = "Фильтр по текущему статусу экипировки")
    OutfitStatus status;
}