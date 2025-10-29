package org.apatrios.service.services.claim;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Claim;
import org.apatrios.model.services.ClaimStatus;
import org.apatrios.model.services.QClaim;
import org.apatrios.repository.services.ClaimRepository;
import org.apatrios.service.services.claim.argument.CreateClaimArgument;
import org.apatrios.service.services.claim.argument.SearchClaimArgument;
import org.apatrios.service.services.claim.argument.UpdateClaimArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository repository;
    private final QClaim qClaim = QClaim.claim;

    @Transactional
    public Claim create(@NonNull CreateClaimArgument argument) {
        return repository.save(Claim.builder()
                                    .claimType(argument.getClaimType())
                                    .parentRent(argument.getParentRent())
                                    .createDate(LocalDateTime.now())
                                    .startDate(LocalDateTime.now())
                                    .note(argument.getNote())
                                    .status(ClaimStatus.CREATED)
                                    .updateDate(LocalDateTime.now())
                                    .franchiseeIds(argument.getFranchiseeIds())
                                    .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Claim update(@NonNull UUID id, @NonNull UpdateClaimArgument argument) {
        Claim existing = getExisting(id);

        existing.setClaimType(argument.getClaimType());
        existing.setNote(argument.getNote());
        existing.setStatus(argument.getStatus());
        existing.setEndDate(argument.getEndDate());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setParentRent(argument.getParentRent());
        existing.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Claim> list(@NonNull SearchClaimArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Claim> page(@NonNull SearchClaimArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchClaimArgument argument) {
        return QPredicates.builder()
                          .add(argument.getClaimTypeId(), qClaim.claimType.id::eq)
                          .add(argument.getParentRentId(), qClaim.parentRent.id::eq)
                          .add(argument.getNote(), qClaim.note::containsIgnoreCase)
                          .add(argument.getStatus(), qClaim.status::eq)
                          .add(argument.getCreateDateFrom(), qClaim.createDate::goe)
                          .add(argument.getCreateDateTo(), qClaim.createDate::loe)
                          .add(argument.getEndDateFrom(), qClaim.endDate::goe)
                          .add(argument.getEndDateTo(), qClaim.endDate::loe)
                          .add(argument.getStartDateFrom(), qClaim.startDate::goe)
                          .add(argument.getStartDateTo(), qClaim.startDate::loe)
                          .add(argument.getUpdateDateFrom(), qClaim.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qClaim.updateDate::loe)
                          .add(argument.isDeleted(), qClaim.isDeleted::eq)
                          .add(argument.getFranchiseeIds(), qClaim.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qClaim.claimType.name::containsIgnoreCase,
                                        qClaim.note::containsIgnoreCase,
                                        qClaim.status.stringValue()::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Claim getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Claim.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Claim existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
