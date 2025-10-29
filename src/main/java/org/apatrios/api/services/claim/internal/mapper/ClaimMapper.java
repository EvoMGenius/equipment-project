package org.apatrios.api.services.claim.internal.mapper;

import org.apatrios.action.services.claim.create.CreateClaimActionArgument;
import org.apatrios.action.services.claim.update.UpdateClaimActionArgument;
import org.apatrios.api.services.claim.internal.dto.ClaimDto;
import org.apatrios.api.services.claim.internal.dto.CreateClaimDto;
import org.apatrios.api.services.claim.internal.dto.SearchClaimDto;
import org.apatrios.api.services.claim.internal.dto.UpdateClaimDto;
import org.apatrios.model.services.Claim;
import org.apatrios.service.services.claim.argument.SearchClaimArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClaimMapper {
    ClaimMapper CLAIM_MAPPER = Mappers.getMapper(ClaimMapper.class);

    ClaimDto toDto(Claim claim);
    CreateClaimActionArgument toCreateArgument(CreateClaimDto dto);
    UpdateClaimActionArgument toUpdateArgument(UpdateClaimDto dto);
    SearchClaimArgument toSearchArgument(SearchClaimDto dto);
}
