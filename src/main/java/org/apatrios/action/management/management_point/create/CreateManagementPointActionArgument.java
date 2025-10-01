package org.apatrios.action.management.management_point.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateManagementPointActionArgument {
    String name;

    String address;

    UUID franchiseeId;

    UUID pointTypeId;

    Double latitude;

    Double longitude;
}
