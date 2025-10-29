package org.apatrios.service.equipment.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.EquipmentComponentStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchEquipmentComponentArgument {
    UUID modelId;
    Integer invNumber;
    String searchString;
    EquipmentComponentStatus status;
    String comment;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    Set<UUID> franchiseeIds;
}