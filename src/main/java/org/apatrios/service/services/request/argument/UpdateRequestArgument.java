package org.apatrios.service.services.request.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.model.dictoinary.ServiceType;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.RequestProfile;
import org.apatrios.model.services.RequestStatus;

@Value
@Builder
public class UpdateRequestArgument {
    RequestProfile requestProfile;

    ServiceType serviceType;

    ModelBike modelBike;

    String note;

    Client client;

    RequestStatus status;

    RejectionReason rejectionReason;

    String rejectNote;
}
