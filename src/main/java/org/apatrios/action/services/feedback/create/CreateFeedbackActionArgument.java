package org.apatrios.action.services.feedback.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateFeedbackActionArgument {
    UUID entityTypeId;
    UUID parentEntityId;
    String description;
    Integer evaluation;
}
