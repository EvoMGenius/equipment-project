package org.apatrios.api.equipment.equipment_component.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.equipment.EquipmentComponentStatus;

import java.time.LocalDateTime;
import java.util.Set;
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

    @Schema(description = "Строка поиска")
    String searchString;

    @Schema(description = "Статус компонента", example = "ACTIVE")
    EquipmentComponentStatus status;

    @Schema(description = "Комментарий или примечание", example = "Требуется диагностика")
    String comment;

    @Schema(description = "Дата создания начало")
    LocalDateTime createDateFrom;

    @Schema(description = "Дата создания конец")
    LocalDateTime createDateTo;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateFrom;

    @Schema(description = "Дата обновления начало")
    LocalDateTime updateDateTo;

    @Schema(description = "Признак удаления")
    boolean isDeleted;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;
}