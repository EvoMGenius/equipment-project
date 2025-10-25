package org.apatrios.service.equipment.maintenance.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class CreateMaintenanceArgument {

    String bicycleVin;

    List<String> completedWork;

    LocalDateTime startDate;

    LocalDateTime endDate;
}
