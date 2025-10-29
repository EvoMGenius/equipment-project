package org.apatrios.action.services.recruit.create;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRecruitActionArgument {
    UUID clientId;
    Set<UUID> franchiseeIds;
}
