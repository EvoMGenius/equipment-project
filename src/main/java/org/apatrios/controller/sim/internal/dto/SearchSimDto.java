package org.apatrios.controller.sim.internal.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchSimDto {
    private String phoneNumber;
    private UUID operatorId;
}