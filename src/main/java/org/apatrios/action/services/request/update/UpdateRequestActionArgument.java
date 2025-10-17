package org.apatrios.action.services.request.update;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RequestProfile;
import org.apatrios.model.services.RequestStatus;

import java.util.UUID;

@Value
@Builder
public class UpdateRequestActionArgument {
    UUID id;

    RequestProfile requestProfile;

    UUID serviceTypeId;

    UUID modelBikeId;

    String note;

    UUID clientId;

    RequestStatus status;
}
