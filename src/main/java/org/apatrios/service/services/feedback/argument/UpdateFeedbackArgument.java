package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ServiceDictionary;

@Value
@Builder
public class UpdateFeedbackArgument {
    Integer rate;

    String note;

    ServiceDictionary serviceDictionary;
}
