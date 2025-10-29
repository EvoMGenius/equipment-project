package org.apatrios.action.equipment.equipment_component.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateEquipmentComponentActionArgument {
    UUID componentModelId;
    Integer invNumber;
    String comment;
    Set<UUID> franchiseeIds;
}
