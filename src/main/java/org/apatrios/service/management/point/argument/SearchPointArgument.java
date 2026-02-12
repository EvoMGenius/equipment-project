package org.apatrios.service.management.point.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class SearchPointArgument {
    UUID pointTypeId;

    String name;

    String number;

    String address;

    String workTime;

    UUID statusId;
}
