package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.model.management.Staff;

import java.util.UUID;

@Value
@Builder
public class CreateRepairArgument {
    UUID objectId;

    RepairType repairType;

    Staff staff;

    String description;

    String comment;
}
