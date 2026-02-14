package org.apatrios.service.services.repair.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Point;
import org.apatrios.model.services.Photo;

import java.util.List;

@Value
@Builder
public class CreateRepairArgument {
    String number;
    Dict fixType;
    String problem;
    Status status;
    Point point;
    List<Photo> photos;
}
