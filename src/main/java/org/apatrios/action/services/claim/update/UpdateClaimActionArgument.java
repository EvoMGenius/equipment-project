package org.apatrios.action.services.claim.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClaimStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateClaimActionArgument {
    UUID id;
    UUID parentRentId;
    UUID claimTypeId;
    String note;
    LocalDateTime endDate;
    ClaimStatus status;
    Set<UUID> franchiseeIds;
}
