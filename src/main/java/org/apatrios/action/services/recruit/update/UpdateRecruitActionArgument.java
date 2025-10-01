package org.apatrios.action.services.recruit.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateRecruitActionArgument {
    UUID id;
    UUID clientId;
    UUID serviceId;
}
