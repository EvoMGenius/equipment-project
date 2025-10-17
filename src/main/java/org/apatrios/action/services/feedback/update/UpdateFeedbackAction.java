package org.apatrios.action.services.feedback.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.dictionary.ServiceDictionaryService;
import org.apatrios.service.services.feedback.FeedbackService;
import org.apatrios.service.services.feedback.argument.UpdateFeedbackArgument;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateFeedbackAction implements Action<UpdateFeedbackActionArgument, Feedback> {

    FeedbackService feedbackService;
    ServiceDictionaryService serviceDictionaryService;

    @Override
    public Feedback execute(@NonNull UpdateFeedbackActionArgument argument) {
        ServiceDictionary serviceDictionary = serviceDictionaryService.getExisting(argument.getServiceDictionaryId());
        return feedbackService.update(argument.getId(),
                                      UpdateFeedbackArgument.builder()
                                                            .serviceDictionary(serviceDictionary)
                                                            .note(argument.getNote())
                                                            .rate(argument.getRate())
                                                            .build());
    }
}
