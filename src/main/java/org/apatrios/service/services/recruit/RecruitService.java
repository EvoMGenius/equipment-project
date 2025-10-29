package org.apatrios.service.services.recruit;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Recruit;
import org.apatrios.model.services.QRecruit;
import org.apatrios.repository.services.RecruitRepository;
import org.apatrios.service.services.recruit.argument.CreateRecruitArgument;
import org.apatrios.service.services.recruit.argument.UpdateRecruitArgument;
import org.apatrios.service.services.recruit.argument.SearchRecruitArgument;
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
public class RecruitService {

    private final RecruitRepository repository;
    private final QRecruit qRecruit = QRecruit.recruit;

    @Transactional
    public Recruit create(@NonNull CreateRecruitArgument argument) {
        return repository.save(Recruit.builder()
                                      .client(argument.getClient())
                                      .createDate(LocalDateTime.now())
                                      .updateDate(LocalDateTime.now())
                                      .franchiseeIds(argument.getFranchiseeIds())
                                      .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Recruit update(@NonNull UUID id, @NonNull UpdateRecruitArgument argument) {
        Recruit existing = getExisting(id);

        existing.setClient(argument.getClient());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Recruit> list(@NonNull SearchRecruitArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Recruit> page(@NonNull SearchRecruitArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRecruitArgument argument) {
        return QPredicates.builder()
                          .add(argument.getClientId(), qRecruit.client.id::eq)
                          .add(argument.isDeleted(), qRecruit.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qRecruit.createDate::goe)
                          .add(argument.getCreateDateTo(), qRecruit.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qRecruit.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qRecruit.updateDate::loe)
                          .add(argument.getFranchiseeIds(), qRecruit.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qRecruit.client.clientProfile.name::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Recruit getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Recruit.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Recruit existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
