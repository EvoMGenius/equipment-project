package org.apatrios.service.simbalance.argument;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchSimBalanceArgument {
    Integer value;
    UUID simId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
}