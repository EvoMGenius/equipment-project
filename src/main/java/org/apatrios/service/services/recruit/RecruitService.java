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
import org.apatrios.service.services.recruit.argument.SearchRecruitArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
                                      .createDate(LocalDateTime.now())
                                      .recruitCompanyName(argument.getRecruitCompanyName())
                                      .status(argument.getStatus())
                                      .build());
    }

    @Transactional(readOnly = true)
    public List<Recruit> list(@NonNull SearchRecruitArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchRecruitArgument argument) {
        return QPredicates.builder()
                          .add(argument.getStatusId(), qRecruit.status.id::eq)
                          .add(argument.getRecruitCompanyName(), qRecruit.recruitCompanyName::containsIgnoreCase)
                          .add(argument.getStartDate(), qRecruit.createDate::goe)
                          .add(argument.getEndDate(), qRecruit.createDate::loe)
                          .addAnyString(argument.getSearchString(), qRecruit.recruitCompanyName::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Recruit getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Recruit.notFound"));
    }
}
