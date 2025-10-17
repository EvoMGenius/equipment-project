package org.apatrios.service.services.claim.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.model.services.Rent;

@Value
@Builder
public class CreateClaimArgument {
    Rent parentRent;

    ClaimType claimType;

    String note;
}
