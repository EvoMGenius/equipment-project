package org.apatrios.controller.sim.internal.dto;

import lombok.*;
import org.apatrios.model.dictoinary.Operator;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimDto {
    private UUID id;
    private String phoneNumber;
    private Operator operator;
}