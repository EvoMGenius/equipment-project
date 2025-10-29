package org.apatrios.service.services.claim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClaimStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class SearchClaimArgument {
    Set<UUID> franchiseeIds;
    UUID parentRentId;
    String searchString;
    UUID claimTypeId;
    ClaimStatus status;
    String note;
    LocalDateTime startDateFrom;
    LocalDateTime startDateTo;
    LocalDateTime endDateFrom;
    LocalDateTime endDateTo;
    LocalDateTime createDateFrom;
    LocalDateTime createDateTo;
    LocalDateTime updateDateFrom;
    LocalDateTime updateDateTo;
    boolean isDeleted;
}
