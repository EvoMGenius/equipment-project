package org.apatrios.controller.simbalance.internal.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchSimBalanceDto {
    private Integer value;
    private UUID simId;
    private LocalDateTime createDateFrom;
    private LocalDateTime createDateTo;
}