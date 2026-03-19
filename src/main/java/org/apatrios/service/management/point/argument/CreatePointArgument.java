package org.apatrios.service.management.point.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Company;

@Builder
public record CreatePointArgument(
        String name,
        String address,
        Company company,
        PointType pointType,
        Double latitude,
        Double longitude
) {
}
