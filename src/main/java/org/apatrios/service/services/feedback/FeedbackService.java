package org.apatrios.service.services.feedback;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository repository;
    private final QFeedback qFeedback = QFeedback.feedback;

    @Transactional
    public Feedback create(@NonNull CreateFeedbackArgument argument) {
        return repository.save(Feedback.builder()
                                       .parentEntityId(argument.parentEntityId())
                                       .entityType(argument.entityType())
                                       .description(argument.description())
                                       .evaluation(argument.evaluation())
                                       .build());
    }

    @Transactional(readOnly = true)
    public Page<Feedback> page(@NonNull SearchFeedbackArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchFeedbackArgument argument) {
        return QPredicates.builder()
                          .add(argument.description(), qFeedback.description::containsIgnoreCase)
                          .add(argument.parentEntityId(), qFeedback.parentEntityId::eq)
                          .add(argument.evaluation(), qFeedback.evaluation::eq)
                          .add(argument.entityType(), qFeedback.entityType::containsIgnoreCase)
                          .addAnyString(argument.searchString(), qFeedback.description::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Feedback getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Feedback.notFound"));
    }
}
