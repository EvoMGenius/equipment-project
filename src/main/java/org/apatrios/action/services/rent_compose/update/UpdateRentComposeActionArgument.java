package org.apatrios.action.services.rent_compose.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateRentComposeActionArgument {
    UUID rentId;

    UUID id;

    Integer amount;

    UUID objectId;
}
