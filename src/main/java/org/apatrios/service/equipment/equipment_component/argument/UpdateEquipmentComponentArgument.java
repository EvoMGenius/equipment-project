package org.apatrios.service.equipment.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.model.equipment.EquipmentComponentStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateEquipmentComponentArgument {
    ComponentModel model;
    Integer invNumber;
    EquipmentComponentStatus status;
    String comment;
    Set<UUID> franchiseeIds;
}