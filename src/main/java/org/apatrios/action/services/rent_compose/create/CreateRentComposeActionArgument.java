package org.apatrios.action.services.rent_compose.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRentComposeActionArgument {
    UUID rentId;
    Set<UUID> franchiseeIds;
    Integer amount;
    UUID objectId;
}
