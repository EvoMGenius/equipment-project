package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RepairStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchRepairArgument {
    Set<UUID> franchiseeIds;
    UUID objectId;
    String searchString;
    UUID repairTypeId;
    UUID staffId;
    String description;
    RepairStatus status;
    LocalDateTime createDate;
    LocalDateTime dateEnd;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
    String comment;
}
