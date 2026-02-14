package org.apatrios.action.management.point.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreatePointActionArgument {
    UUID pointTypeId;

    String name;

    String number;

    String address;

    String workTime;

    UUID statusId;
}
