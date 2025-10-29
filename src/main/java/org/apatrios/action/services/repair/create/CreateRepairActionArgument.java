package org.apatrios.action.services.repair.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRepairActionArgument {
    UUID objectId;
    Set<UUID> franchiseeIds;
    UUID repairTypeId;
    UUID staffId;
    String description;
    String comment;
}
