package org.apatrios.service.dictionary.argument;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Value
@Builder
public class SearchModelBikeArgument extends BaseDictionarySearchArgument {
    String weight;
    String maxLoad;
    String range;
    String maxSpeed;
    List<UUID> photoIds;
}
