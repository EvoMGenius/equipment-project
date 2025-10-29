package org.apatrios.action.services.rent_compose.update;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateRentComposeActionArgument {
    UUID rentId;
    Set<UUID> franchiseeIds;
    UUID id;
    Integer amount;
    UUID objectId;
}
