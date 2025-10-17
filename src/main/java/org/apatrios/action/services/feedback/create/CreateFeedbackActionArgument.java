package org.apatrios.action.services.feedback.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateFeedbackActionArgument {
    Integer rate;

    String note;

    UUID serviceDictionaryId;
}
