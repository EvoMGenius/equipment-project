package org.apatrios.service.equipment.maintenance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.MaintenanceStatus;

import java.time.LocalDateTime;

@Value
@Builder
public class SearchMaintenanceArgument {

    String bicycleVin;

    String completedWork;

    LocalDateTime startDateFrom;

    LocalDateTime startDateTo;

    LocalDateTime endDateFrom;

    LocalDateTime endDateTo;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;

    MaintenanceStatus status;
}
