package org.apatrios.service.equipment.maintenance.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.MaintenanceStatus;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class UpdateMaintenanceArgument {

    String bicycleVin;

    List<String> completedWork;

    LocalDateTime startDate;

    LocalDateTime endDate;

    MaintenanceStatus status;
}
