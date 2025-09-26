package org.apatrios.service.component.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ComponentModel;

@Value
@Builder
public class UpdateComponentArgument {
    ComponentModel model;
    Integer invNumber;
    String status;
    String comment;
}