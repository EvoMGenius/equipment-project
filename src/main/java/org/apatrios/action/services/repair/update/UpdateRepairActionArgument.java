package org.apatrios.action.services.repair.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateRepairActionArgument {
    UUID id;
    Set<UUID> franchiseeIds;
    UUID objectId;
    UUID repairTypeId;
    UUID staffId;
    String description;
    String comment;
    RepairStatus status;
    LocalDateTime dateEnd;
}
