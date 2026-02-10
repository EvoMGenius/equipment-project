package org.apatrios.service.services.feedback;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Feedback;
import org.apatrios.model.services.QFeedback;
import org.apatrios.repository.services.FeedbackRepository;
import org.apatrios.service.services.feedback.argument.CreateFeedbackArgument;
import org.apatrios.service.services.feedback.argument.SearchFeedbackArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository repository;
    private final QFeedback qFeedback = QFeedback.feedback;

    @Transactional
    public Feedback create(@NonNull CreateFeedbackArgument argument) {
        return repository.save(Feedback.builder()
                                       .serviceDictionary(argument.getServiceDictionary())
                                       .rate(argument.getRate())
                                       .note(argument.getNote())
                                       .createDate(LocalDateTime.now())
                                       .updateDate(LocalDateTime.now())
                                       .franchiseeIds(argument.getFranchiseeIds())
                                       .build());
    }

    @Transactional(readOnly = true)
    public List<Feedback> list(@NonNull SearchFeedbackArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchFeedbackArgument argument) {
        return QPredicates.builder()
                          .add(argument.getRate(), qFeedback.rate::eq)
                          .add(argument.getNote(), qFeedback.note::containsIgnoreCase)
                          .add(argument.isDeleted(), qFeedback.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qFeedback.createDate::goe)
                          .add(argument.getCreateDateTo(), qFeedback.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qFeedback.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qFeedback.updateDate::loe)
                          .add(argument.getServiceDictionaryId(), qFeedback.serviceDictionary.id::eq)
                          .add(argument.getFranchiseeIds(), qFeedback.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qFeedback.note::containsIgnoreCase,
                                        qFeedback.rate.stringValue()::containsIgnoreCase,
                                        qFeedback.serviceDictionary.name::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Feedback getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Feedback.notFound"));
    }
}
