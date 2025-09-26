package org.apatrios.controller.component.internal.dto;

import lombok.*;
import org.apatrios.model.dictoinary.ComponentModel;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComponentDto {
    private UUID id;
    private ComponentModel model;
    private Integer invNumber;
    private String status;
    private String comment;
}