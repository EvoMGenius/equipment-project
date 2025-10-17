package org.apatrios.service.services.claim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.model.services.ClaimStatus;
import org.apatrios.model.services.Rent;

import java.time.LocalDateTime;

@Value
@Builder
public class UpdateClaimArgument {
    Rent parentRent;

    ClaimType claimType;

    LocalDateTime endDate;

    String note;

    ClaimStatus status;
}
