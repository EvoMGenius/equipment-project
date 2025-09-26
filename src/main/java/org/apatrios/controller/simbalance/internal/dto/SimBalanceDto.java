package org.apatrios.controller.simbalance.internal.dto;

import lombok.*;
import org.apatrios.controller.sim.internal.dto.SimDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimBalanceDto {
    private UUID id;
    private Integer value;
    private SimDto sim;
    private LocalDateTime createDate;
}