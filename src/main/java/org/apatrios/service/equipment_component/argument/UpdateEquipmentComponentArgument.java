package org.apatrios.service.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ComponentModel;

@Value
@Builder
public class UpdateEquipmentComponentArgument {
    ComponentModel model;
    Integer invNumber;
    String status;
    String comment;
}