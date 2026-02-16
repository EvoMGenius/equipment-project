package org.apatrios.service.services.recruit;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Recruit;
import org.apatrios.model.services.QRecruit;
import org.apatrios.model.services.RecruitStatus;
import org.apatrios.repository.services.RecruitRepository;
import org.apatrios.service.services.recruit.argument.CreateRecruitArgument;
import org.apatrios.service.services.recruit.argument.SearchRecruitArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
                                      .status(RecruitStatus.CREATED)
                                      .build());
    }

    @Transactional(readOnly = true)
    public Page<Recruit> page(@NonNull SearchRecruitArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRecruitArgument argument) {
        return QPredicates.builder()
                          .add(argument.getStatus(), qRecruit.status::eq)
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
