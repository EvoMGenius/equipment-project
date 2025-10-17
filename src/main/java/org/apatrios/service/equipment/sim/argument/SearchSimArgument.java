package org.apatrios.service.equipment.sim.argument;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchSimArgument {
    String phoneNumber;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
}