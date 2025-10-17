package org.apatrios.api.services.claim.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.claim.create.CreateClaimActionArgument;
import org.apatrios.action.services.claim.update.UpdateClaimActionArgument;
import org.apatrios.api.services.claim.internal.dto.ClaimDto;
import org.apatrios.api.services.claim.internal.dto.CreateClaimDto;
import org.apatrios.api.services.claim.internal.dto.SearchClaimDto;
import org.apatrios.api.services.claim.internal.dto.UpdateClaimDto;
import org.apatrios.model.services.Claim;
import org.apatrios.service.services.claim.ClaimService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.claim.internal.mapper.ClaimMapper.CLAIM_MAPPER;

@RestController
@RequestMapping("claim")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClaimController {

    Action<CreateClaimActionArgument, Claim> createClaimAction;
    Action<UpdateClaimActionArgument, Claim> updateClaimAction;
    ClaimService service;

    @PostMapping("create")
    public ClaimDto create(@Valid @RequestBody CreateClaimDto dto) {
        return CLAIM_MAPPER.toDto(createClaimAction.execute(CLAIM_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public ClaimDto update(@Valid @RequestBody UpdateClaimDto dto) {
        return CLAIM_MAPPER.toDto(updateClaimAction.execute(CLAIM_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<ClaimDto> list(SearchClaimDto dto, Sort sort) {
        return service.list(CLAIM_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(CLAIM_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<ClaimDto> page(SearchClaimDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(CLAIM_MAPPER.toSearchArgument(dto), pageable)
                                       .map(CLAIM_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
