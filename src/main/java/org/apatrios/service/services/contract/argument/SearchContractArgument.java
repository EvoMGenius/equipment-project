package org.apatrios.service.services.contract.argument;

import lombok.Builder;
import org.apatrios.model.services.ContactStatus;

import java.util.UUID;

@Builder
public record SearchContractArgument(
        UUID recruitId,
        UUID docId,
        ContactStatus status
) {
}
