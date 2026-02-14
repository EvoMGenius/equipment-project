package org.apatrios.action.services.repair.create;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRepairActionArgument {
    String number;
    UUID fixTypeId;
    String problem;
    UUID statusId;
    UUID pointId;
    List<UUID> photoIds;
}
