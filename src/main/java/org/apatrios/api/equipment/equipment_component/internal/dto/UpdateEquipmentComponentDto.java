package org.apatrios.api.equipment.equipment_component.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.EquipmentComponentStatus;

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
@Schema(description = "DTO обновления компонента")
public class UpdateEquipmentComponentDto {

    @NotNull
    @Schema(description = "Идентификатор компонента", example = "2f4e3b1a-7b2d-43d3-b8f7-92a7d5c5e123")
    UUID id;

    @NotNull
    @Schema(description = "ID Модели компонента")
    UUID componentModelId;

    @NotNull
    @Schema(description = "Инвентарный номер компонента", example = "56789")
    Integer invNumber;

    @NotNull
    @Schema(description = "Статус компонента", example = "ACTIVE")
    EquipmentComponentStatus status;

    @Schema(description = "Комментарий или примечание", example = "Требуется диагностика")
    String comment;
}