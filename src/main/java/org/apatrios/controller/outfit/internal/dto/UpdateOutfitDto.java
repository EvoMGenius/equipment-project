package org.apatrios.controller.outfit.internal.dto;

import lombok.*;
import org.apatrios.model.OutfitStatus;
import org.apatrios.model.dictoinary.OutfitModel;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOutfitDto {
    private OutfitModel model;
    private Integer invNumber;
    private OutfitStatus status;
    private String comment;
}