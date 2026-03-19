package org.apatrios.action.services.repair.argument;

import lombok.Builder;
import org.apatrios.model.services.Photo;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateRepairActionArgument(
        String number,
        String fixType,
        String problem,
        UUID pointId,
        List<Photo> photos
) {
}
