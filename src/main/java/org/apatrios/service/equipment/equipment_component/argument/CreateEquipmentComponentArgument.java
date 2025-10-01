package org.apatrios.service.equipment.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ComponentModel;

@Value
@Builder
public class CreateEquipmentComponentArgument {
    ComponentModel model;
    Integer invNumber;
    String status;
    String comment;
}