package org.apatrios.action.services.feedback.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.services.feedback.FeedbackService;
import org.apatrios.service.services.feedback.argument.CreateFeedbackArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateFeedbackAction implements Action<CreateFeedbackActionArgument, Feedback> {

    FeedbackService feedbackService;
    DictService dictService;

    @Override
    @Transactional
    public Feedback execute(@NonNull CreateFeedbackActionArgument argument) {
        Dict dict = dictService.getExisting(argument.getEntityTypeId());
        return feedbackService.create(CreateFeedbackArgument.builder()
                                                            .parentEntityId(argument.getParentEntityId())
                                                            .entityType(dict)
                                                            .description(argument.getDescription())
                                                            .evaluation(argument.getEvaluation())
                                                            .build());
    }
}
