package org.apatrios.service.management.point.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.PointStatus;

import java.util.UUID;

@Value
@Builder
public class SearchPointArgument {
    UUID pointTypeId;

    String name;

    String number;

    String address;

    String workTime;

    PointStatus status;
}
