package org.apatrios.service.equipment.equipment_component.argument;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;

@Value
@Builder
public class SearchEquipmentComponentArgument {
    UUID modelId;
    Integer invNumber;
    String status;
    String comment;
}