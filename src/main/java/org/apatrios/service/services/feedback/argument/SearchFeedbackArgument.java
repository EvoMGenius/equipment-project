package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class SearchFeedbackArgument {
    UUID entityTypeId;
    UUID parentEntityId;
    String description;
    Integer evaluation;
    String searchString;
}
