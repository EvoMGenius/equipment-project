package org.apatrios.service.management.franchisee;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.FranchiseeStatus;
import org.apatrios.model.management.QFranchisee;
import org.apatrios.repository.managment.FranchiseeRepository;
import org.apatrios.service.management.franchisee.argument.CreateFranchiseeArgument;
import org.apatrios.service.management.franchisee.argument.SearchFranchiseeArgument;
import org.apatrios.service.management.franchisee.argument.UpdateFranchiseeArgument;
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
public class FranchiseeService {

    private final FranchiseeRepository repository;
    private final QFranchisee qFranchisee = QFranchisee.franchisee;

    @Transactional
    public Franchisee create(@NonNull CreateFranchiseeArgument argument) {
        return repository.save(Franchisee.builder()
                                         .franchiseeProfile(argument.getFranchiseeProfile())
                                         .inn(argument.getInn())
                                         .status(FranchiseeStatus.ACTIVE)
                                         .createDate(LocalDateTime.now())
                                         .updateDate(LocalDateTime.now())
                                         .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Franchisee update(@NonNull UUID id, @NonNull UpdateFranchiseeArgument argument) {
        Franchisee existing = getExisting(id);

        existing.setFranchiseeProfile(argument.getFranchiseeProfile());
        existing.setInn(argument.getInn());
        existing.setStatus(argument.getStatus());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Franchisee> list(@NonNull SearchFranchiseeArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Franchisee> page(@NonNull SearchFranchiseeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchFranchiseeArgument argument) {
        return QPredicates.builder()
                          .add(argument.getName(), qFranchisee.franchiseeProfile.name::containsIgnoreCase)
                          .add(argument.getInn(), qFranchisee.inn::eq)
                          .add(argument.getAddress(), qFranchisee.franchiseeProfile.address::containsIgnoreCase)
                          .add(argument.getPhone(), qFranchisee.franchiseeProfile.phone::containsIgnoreCase)
                          .add(argument.getEmail(), qFranchisee.franchiseeProfile.email::containsIgnoreCase)
                          .add(argument.getStatus(), qFranchisee.status::eq)
                          .add(argument.isDeleted(), qFranchisee.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qFranchisee.createDate::goe)
                          .add(argument.getCreateDateTo(), qFranchisee.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qFranchisee.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qFranchisee.updateDate::loe)
                          .addAnyString(argument.getSearchString(),
                                        qFranchisee.status.stringValue()::containsIgnoreCase,
                                        qFranchisee.inn::containsIgnoreCase,
                                        qFranchisee.franchiseeProfile.name::containsIgnoreCase,
                                        qFranchisee.franchiseeProfile.email::containsIgnoreCase,
                                        qFranchisee.franchiseeProfile.address::containsIgnoreCase,
                                        qFranchisee.franchiseeProfile.phone::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Franchisee getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Franchisee.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Franchisee existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
