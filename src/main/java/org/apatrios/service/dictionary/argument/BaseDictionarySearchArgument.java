package org.apatrios.service.dictionary.argument;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseDictionarySearchArgument {
    String name;
}
