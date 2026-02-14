package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;

import java.util.UUID;

@Value
@Builder
public class CreateFeedbackArgument {
    Dict entityType;
    UUID parentEntityId;
    String description;
    Integer evaluation;
}
