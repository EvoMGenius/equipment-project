package org.apatrios.service.management.management_point.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.PointStatus;


@Value
@Builder
public class UpdateManagementPointArgument {

    String name;

    String address;

    Franchisee franchisee;

    PointType pointType;

    PointStatus status;

    Double latitude;

    Double longitude;
}
