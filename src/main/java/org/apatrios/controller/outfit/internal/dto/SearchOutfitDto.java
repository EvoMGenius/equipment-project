package org.apatrios.controller.outfit.internal.dto;

import lombok.*;
import org.apatrios.model.OutfitStatus;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchOutfitDto {
    private UUID modelId;
    private Integer invNumber;
    private OutfitStatus status;
    private String comment;
}