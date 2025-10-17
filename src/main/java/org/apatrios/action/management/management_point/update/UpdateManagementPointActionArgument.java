package org.apatrios.action.management.management_point.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PointStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateManagementPointActionArgument {
    UUID id;

    String name;

    String address;

    UUID franchiseeId;

    UUID pointTypeId;

    PointStatus status;

    Double latitude;

    Double longitude;
}
