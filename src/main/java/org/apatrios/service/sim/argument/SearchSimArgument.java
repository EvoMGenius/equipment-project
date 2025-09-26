package org.apatrios.service.sim.argument;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;

@Value
@Builder
public class SearchSimArgument {
    String phoneNumber;
    UUID operatorId;
}