package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.management.Point;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.RepairStatus;

import java.util.List;

@Value
@Builder
public class CreateRepairArgument {
    String number;
    Dict fixType;
    String problem;
    Point point;
    List<Photo> photos;
}
