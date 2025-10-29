package org.apatrios.action.services.request.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RequestProfile;
import org.apatrios.model.services.RequestStatus;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateRequestActionArgument {
    UUID id;
    Set<UUID> franchiseeIds;
    RequestProfile requestProfile;
    UUID serviceTypeId;
    UUID modelBikeId;
    String note;
    UUID clientId;
    RequestStatus status;
    UUID rejectionReasonId;
    String rejectNote;
}
