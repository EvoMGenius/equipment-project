package org.apatrios.controller.sim.internal.dto;

import lombok.*;
import org.apatrios.model.dictoinary.Operator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSimDto {
    private String phoneNumber;
    private Operator operator;
}