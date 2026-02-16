package org.apatrios.api.equipment.outfit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
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
    @Schema(description = "Имя")
    String name;

    @Schema(description = "Тарифы")
    List<UUID> tariffIds;

    @Schema(description = "Выбранный тариф")
    UUID chosenTariffId;
}