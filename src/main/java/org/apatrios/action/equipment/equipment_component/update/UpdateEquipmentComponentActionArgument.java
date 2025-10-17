package org.apatrios.action.equipment.equipment_component.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateEquipmentComponentActionArgument {
    UUID id;
    UUID componentModelId;
    Integer invNumber;
    String comment;
}
