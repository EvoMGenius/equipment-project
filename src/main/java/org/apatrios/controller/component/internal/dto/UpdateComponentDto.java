package org.apatrios.controller.component.internal.dto;

import lombok.*;
import org.apatrios.model.dictoinary.ComponentModel;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateComponentDto {
    private ComponentModel model;
    private Integer invNumber;
    private String status;
    private String comment;
}