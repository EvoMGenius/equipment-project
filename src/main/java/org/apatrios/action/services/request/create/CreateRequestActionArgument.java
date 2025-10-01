package org.apatrios.action.services.request.create;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.RequestProfile;

import java.util.UUID;

@Value
@Builder
public class CreateRequestActionArgument {
    RequestProfile requestProfile;

    UUID serviceTypeId;

    UUID modelBikeId;

    String note;

    UUID clientId;
}
