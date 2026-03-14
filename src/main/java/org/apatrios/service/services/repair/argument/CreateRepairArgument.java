package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import org.apatrios.model.management.Point;
import org.apatrios.model.services.Photo;

import java.util.List;

@Builder
public record CreateRepairArgument(
        String number,
        String fixType,
        String problem,
        Point point,
        List<Photo> photos
) {}
