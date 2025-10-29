package org.apatrios.service.equipment.maintenance.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateMaintenanceArgument {

    String bicycleVin;

    List<String> completedWork;

    Set<UUID> franchiseeIds;

    LocalDateTime startDate;

    LocalDateTime endDate;
}
