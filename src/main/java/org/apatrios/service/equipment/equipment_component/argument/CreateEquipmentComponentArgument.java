package org.apatrios.service.equipment.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ComponentModel;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateEquipmentComponentArgument {
    ComponentModel model;
    Integer invNumber;
    String comment;
    Set<UUID> franchiseeIds;
}