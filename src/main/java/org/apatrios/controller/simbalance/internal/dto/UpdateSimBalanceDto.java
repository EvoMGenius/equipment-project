package org.apatrios.controller.simbalance.internal.dto;

import lombok.*;
import org.apatrios.model.Sim;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSimBalanceDto {
    private Integer value;
    private Sim sim;
    private LocalDateTime createDate;
}