package org.apatrios.service.equipment.outfit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.OutfitStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchOutfitArgument {
    UUID modelId;
    OutfitStatus status;
    String comment;
    UUID franchiseeId;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
}