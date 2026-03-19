package org.apatrios.action.management.point.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Company;

import java.util.UUID;

@Builder
public record CreatePointActionArgument(
        String name,
        String address,
        UUID companyId,
        UUID pointTypeId,
        Double latitude,
        Double longitude
) {
}
