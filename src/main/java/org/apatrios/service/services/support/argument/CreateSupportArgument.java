package org.apatrios.service.services.support.argument;

import lombok.Builder;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.Repair;

import java.util.List;

@Builder
public record CreateSupportArgument(
        String type,
        String description,
        List<Photo> photo,
        Repair childRepairId
) {}