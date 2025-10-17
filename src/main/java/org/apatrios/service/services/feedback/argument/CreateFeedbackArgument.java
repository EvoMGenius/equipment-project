package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateFeedbackArgument {
    Integer rate;

    String note;
}
