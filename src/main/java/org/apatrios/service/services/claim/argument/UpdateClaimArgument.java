package org.apatrios.service.services.claim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.model.services.ClaimStatus;
import org.apatrios.model.services.Rent;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateClaimArgument {
    Rent parentRent;
    ClaimType claimType;
    LocalDateTime endDate;
    String note;
    ClaimStatus status;
    Set<UUID> franchiseeIds;
}
