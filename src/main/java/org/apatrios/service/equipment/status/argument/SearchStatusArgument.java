package org.apatrios.service.equipment.status.argument;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchStatusArgument {
    String code;
}
