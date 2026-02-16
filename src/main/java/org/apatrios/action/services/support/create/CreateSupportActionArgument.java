package org.apatrios.action.services.support.create;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CreateSupportActionArgument {
    UUID typeId;

    String description;

    List<UUID> photoIds;

    UUID childRepairId;

    UUID statusId;
}
