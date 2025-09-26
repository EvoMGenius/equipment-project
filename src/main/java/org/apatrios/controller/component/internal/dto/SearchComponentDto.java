package org.apatrios.controller.component.internal.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchComponentDto {
    private UUID modelId;
    private Integer invNumber;
    private String status;
    private String comment;
}