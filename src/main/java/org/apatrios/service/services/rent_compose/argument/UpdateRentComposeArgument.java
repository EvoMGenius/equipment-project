package org.apatrios.service.services.rent_compose.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.Rent;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateRentComposeArgument {
    Rent rent;
    Integer amount;
    UUID objectId;
    Set<UUID> franchiseeIds;
}
