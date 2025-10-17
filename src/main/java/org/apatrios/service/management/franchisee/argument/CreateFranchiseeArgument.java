package org.apatrios.service.management.franchisee.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.FranchiseeProfile;

@Value
@Builder
public class CreateFranchiseeArgument {
    String inn;
    FranchiseeProfile franchiseeProfile;
}
