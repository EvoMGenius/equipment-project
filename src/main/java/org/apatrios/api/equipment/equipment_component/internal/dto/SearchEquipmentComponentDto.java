package org.apatrios.api.equipment.equipment_component.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска компонента")
public class SearchEquipmentComponentDto {
    @Schema(description = "Идентификатор модели компонента", example = "5b8a8f6e-2c9d-4e73-83ff-15c1f123abcd")
    UUID modelId;

    @Schema(description = "Инвентарный номер компонента", example = "56789")
    Integer invNumber;

    @Schema(description = "Статус компонента", example = "ACTIVE")
    String status;

    @Schema(description = "Комментарий или примечание", example = "Требуется диагностика")
    String comment;
}