package org.apatrios.action.component.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateComponentActionArgument {
    UUID componentModelId;
    Integer invNumber;
    String status;
    String comment;
}
