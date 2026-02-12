package org.apatrios.service.services.contract.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Document;
import org.apatrios.model.services.Recruit;

@Value
@Builder
public class CreateContractArgument {
    Recruit recruit;
    Document doc;
    Status status;
}
