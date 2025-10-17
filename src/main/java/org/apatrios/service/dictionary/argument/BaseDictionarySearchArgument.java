package org.apatrios.service.dictionary.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.EntityStatus;

@Value
@Builder
public class BaseDictionarySearchArgument {
    String name;
    EntityStatus status;
}
