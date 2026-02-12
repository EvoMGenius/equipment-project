package org.apatrios.service.services.support.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.services.Photo;
import org.apatrios.model.services.Repair;

import java.util.List;

@Value
@Builder
public class CreateSupportArgument {
    Dict type;

    String description;

    List<Photo> photo;

    Repair childRepairId;

    Status status;
}
