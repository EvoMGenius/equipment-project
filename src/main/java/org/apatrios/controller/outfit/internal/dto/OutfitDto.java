package org.apatrios.controller.outfit.internal.dto;

import lombok.*;
import org.apatrios.model.OutfitStatus;
import org.apatrios.model.dictoinary.OutfitModel;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutfitDto {
    private UUID id;
    private OutfitModel model;
    private Integer invNumber;
    private OutfitStatus status;
    private String comment;
}