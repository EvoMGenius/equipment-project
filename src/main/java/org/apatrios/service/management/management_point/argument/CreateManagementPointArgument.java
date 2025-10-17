package org.apatrios.service.management.management_point.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Franchisee;

@Value
@Builder
public class CreateManagementPointArgument {
    String name;

    String address;

    Franchisee franchisee;

    PointType pointType;

    Double latitude;

    Double longitude;
}
