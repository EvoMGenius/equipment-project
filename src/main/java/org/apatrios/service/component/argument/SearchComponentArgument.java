package org.apatrios.service.component.argument;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;

@Value
@Builder
public class SearchComponentArgument {
    UUID modelId;
    Integer invNumber;
    String status;
    String comment;
}