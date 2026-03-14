package org.apatrios.service.services.feedback.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SearchFeedbackArgument(
        String entityType,
        UUID parentEntityId,
        String description,
        Integer evaluation,
        String searchString
) {
}
