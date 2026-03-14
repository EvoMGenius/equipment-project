package org.apatrios.service.services.contract.argument;

import lombok.Builder;
import org.apatrios.model.management.Document;
import org.apatrios.model.services.Recruit;

@Builder
public record CreateContractArgument(
        Recruit recruit,
        Document doc
) {
}
