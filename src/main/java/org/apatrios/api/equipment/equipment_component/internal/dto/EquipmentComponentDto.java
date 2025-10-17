package org.apatrios.api.equipment.equipment_component.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.component_model.dto.ComponentModelDto;
import org.apatrios.model.equipment.EquipmentComponentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO компонента")
public class EquipmentComponentDto {

    @Schema(description = "Идентификатор компонента", example = "2f4e3b1a-7b2d-43d3-b8f7-92a7d5c5e123")
    UUID id;

    @Schema(description = "Модель компонента")
    ComponentModelDto model;

    @Schema(description = "Инвентарный номер компонента", example = "56789")
    Integer invNumber;

    @Schema(description = "Статус компонента", example = "ACTIVE")
    EquipmentComponentStatus status;

    @Schema(description = "Комментарий или примечание", example = "Требуется диагностика")
    String comment;

    @Schema(description = "Дата создания")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}