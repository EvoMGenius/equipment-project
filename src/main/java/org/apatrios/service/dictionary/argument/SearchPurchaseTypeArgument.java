package org.apatrios.service.dictionary.argument;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
@Builder
public class SearchPurchaseTypeArgument extends BaseDictionarySearchArgument {
}
