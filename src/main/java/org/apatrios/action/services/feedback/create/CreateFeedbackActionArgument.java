package org.apatrios.action.services.feedback.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateFeedbackActionArgument {
    Integer rate;
    Set<UUID> franchiseeIds;
    String note;
    UUID serviceDictionaryId;
}
