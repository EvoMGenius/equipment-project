package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateFeedbackArgument {
    Integer rate;

    String note;
}
