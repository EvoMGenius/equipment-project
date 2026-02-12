package org.apatrios.service.services.contract.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class SearchContractArgument {
    UUID recruitId;
    UUID docId;
    UUID statusId;
}
