package org.apatrios.service.services.request.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.RequestProfile;

@Value
@Builder
public class CreateRequestArgument {
    RequestProfile requestProfile;

    RejectionReason rejectionReason;

    String rejectNote;

    ServiceType serviceType;

    ModelBike modelBike;

    String note;

    Client client;
}
