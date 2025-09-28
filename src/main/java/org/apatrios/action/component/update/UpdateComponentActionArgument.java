package org.apatrios.action.component.update;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateComponentActionArgument {
    UUID id;
    UUID componentModelId;
    Integer invNumber;
    String status;
    String comment;
}
