package org.apatrios.action.services.support.argument;

import lombok.Builder;
import org.apatrios.model.services.Photo;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateSupportActionArgument(
        String type,
        String description,
        List<Photo> photos,
        UUID childRepairId
) {
}
