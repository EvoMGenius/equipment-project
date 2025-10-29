package org.apatrios.service.services.rent_compose;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.QRentCompose;
import org.apatrios.model.services.RentCompose;
import org.apatrios.repository.services.RentComposeRepository;
import org.apatrios.service.services.rent_compose.argument.CreateRentComposeArgument;
import org.apatrios.service.services.rent_compose.argument.UpdateRentComposeArgument;
import org.apatrios.service.services.rent_compose.argument.SearchRentComposeArgument;
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
public class RentComposeService {

    private final RentComposeRepository repository;
    private final QRentCompose qRentCompose = QRentCompose.rentCompose;

    @Transactional
    public RentCompose create(@NonNull CreateRentComposeArgument argument) {
        return repository.save(RentCompose.builder()
                                          .rent(argument.getRent())
                                          .amount(argument.getAmount())
                                          .objectId(argument.getObjectId())
                                          .createDate(LocalDateTime.now())
                                          .updateDate(LocalDateTime.now())
                                          .franchiseeIds(argument.getFranchiseeIds())
                                          .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public RentCompose update(@NonNull UUID id, @NonNull UpdateRentComposeArgument argument) {
        RentCompose existing = getExisting(id);

        existing.setRent(argument.getRent());
        existing.setAmount(argument.getAmount());
        existing.setObjectId(argument.getObjectId());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<RentCompose> list(@NonNull SearchRentComposeArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<RentCompose> page(@NonNull SearchRentComposeArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRentComposeArgument argument) {
        return QPredicates.builder()
                          .add(argument.getRentId(), qRentCompose.rent.id::eq)
                          .add(argument.getObjectId(), qRentCompose.objectId::eq)
                          .add(argument.isDeleted(), qRentCompose.isDeleted::eq)
                          .add(argument.getAmount(), qRentCompose.amount::eq)
                          .add(argument.getCreateDateFrom(), qRentCompose.createDate::goe)
                          .add(argument.getCreateDateTo(), qRentCompose.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qRentCompose.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qRentCompose.updateDate::loe)
                          .add(argument.getFranchiseeIds(), qRentCompose.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qRentCompose.amount.stringValue()::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public RentCompose getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("RentCompose.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        RentCompose existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
