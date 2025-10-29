package org.apatrios.action.services.claim.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateClaimActionArgument {
    UUID parentRentId;
    UUID claimTypeId;
    String note;
    Set<UUID> franchiseeIds;
}
