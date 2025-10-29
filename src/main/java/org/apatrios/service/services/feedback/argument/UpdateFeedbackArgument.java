package org.apatrios.service.services.feedback.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ServiceDictionary;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateFeedbackArgument {
    Integer rate;
    String note;
    ServiceDictionary serviceDictionary;
    Set<UUID> franchiseeIds;
}
