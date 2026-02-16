package org.apatrios.service.services.contract.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.services.ContactStatus;

import java.util.UUID;

@Value
@Builder
public class SearchContractArgument {
    UUID recruitId;
    UUID docId;
    ContactStatus status;
}
