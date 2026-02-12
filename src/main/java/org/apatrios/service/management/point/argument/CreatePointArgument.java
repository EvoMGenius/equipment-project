package org.apatrios.service.management.point.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;

@Value
@Builder
public class CreatePointArgument {
    Dict pointType;

    String name;

    String number;

    String address;

    String workTime;

    Status status;
}
