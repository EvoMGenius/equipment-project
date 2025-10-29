package org.apatrios.action.services.claim.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ClaimType;
import org.apatrios.model.services.Claim;
import org.apatrios.model.services.Rent;
import org.apatrios.service.dictionary.ClaimTypeService;
import org.apatrios.service.services.claim.ClaimService;
import org.apatrios.service.services.claim.argument.CreateClaimArgument;
import org.apatrios.service.services.rent.RentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateClaimAction implements Action<CreateClaimActionArgument, Claim> {

    ClaimService claimService;
    ClaimTypeService claimTypeService;
    RentService rentService;

    @Override
    @Transactional
    public Claim execute(@NonNull CreateClaimActionArgument argument) {
        ClaimType claimType = claimTypeService.getExisting(argument.getClaimTypeId());
        Rent rent = rentService.getExisting(argument.getParentRentId());
        return claimService.create(CreateClaimArgument.builder()
                                                      .claimType(claimType)
                                                      .note(argument.getNote())
                                                      .parentRent(rent)
                                                      .franchiseeIds(argument.getFranchiseeIds())
                                                      .build());
    }
}
