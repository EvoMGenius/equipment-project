package org.apatrios.service.services.feedback.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateFeedbackArgument(
        String entityType,
        UUID parentEntityId,
        String description,
        Integer evaluation
) {
}
