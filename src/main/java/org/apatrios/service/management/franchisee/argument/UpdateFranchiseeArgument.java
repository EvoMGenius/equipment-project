package org.apatrios.service.management.franchisee.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.FranchiseeProfile;
import org.apatrios.model.management.FranchiseeStatus;

@Value
@Builder
public class UpdateFranchiseeArgument {
    String inn;
    FranchiseeProfile franchiseeProfile;
    FranchiseeStatus status;

}
