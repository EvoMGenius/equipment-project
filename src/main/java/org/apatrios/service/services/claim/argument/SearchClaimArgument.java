package org.apatrios.service.services.claim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ClaimStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class SearchClaimArgument {

    UUID parentRentId;

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
