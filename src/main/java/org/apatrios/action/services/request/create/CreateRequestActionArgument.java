package org.apatrios.action.services.request.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RequestProfile;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateRequestActionArgument {
    RequestProfile requestProfile;
    Set<UUID> franchiseeIds;
    UUID serviceTypeId;
    UUID modelBikeId;
    String note;
    UUID clientId;
    UUID rejectionReasonId;
    String rejectNote;
}
