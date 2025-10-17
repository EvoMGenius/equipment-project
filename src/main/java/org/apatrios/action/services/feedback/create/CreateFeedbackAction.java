package org.apatrios.action.services.feedback.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.dictionary.ServiceDictionaryService;
import org.apatrios.service.services.feedback.FeedbackService;
import org.apatrios.service.services.feedback.argument.CreateFeedbackArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateFeedbackAction implements Action<CreateFeedbackActionArgument, Feedback> {

    FeedbackService feedbackService;
    ServiceDictionaryService serviceDictionaryService;

    @Override
    @Transactional
    public Feedback execute(@NonNull CreateFeedbackActionArgument argument) {
        ServiceDictionary serviceDictionary = serviceDictionaryService.getExisting(argument.getServiceDictionaryId());
        return feedbackService.create(CreateFeedbackArgument.builder()
                                                            .serviceDictionary(serviceDictionary)
                                                            .note(argument.getNote())
                                                            .rate(argument.getRate())
                                                            .build());
    }
}
