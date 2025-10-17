package org.apatrios.action.services.feedback.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateFeedbackActionArgument {
    UUID id;

    Integer rate;

    String note;

    UUID serviceDictionaryId;
}
