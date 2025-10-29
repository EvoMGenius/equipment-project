package org.apatrios.service.management.management_point.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PointStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchManagementPointArgument {
    String name;

    String address;

    String searchString;

    UUID franchiseeId;

    UUID pointTypeId;

    PointStatus status;

    Double latitude;

    Double longitude;

    LocalDateTime createDateFrom;

    LocalDateTime createDateTo;

    LocalDateTime updateDateFrom;

    LocalDateTime updateDateTo;

    boolean isDeleted;
}
