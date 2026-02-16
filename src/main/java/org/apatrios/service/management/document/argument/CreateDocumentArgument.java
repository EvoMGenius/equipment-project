package org.apatrios.service.management.document.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.management.DocumentStatus;

@Value
@Builder
public class CreateDocumentArgument {
    String name;

    Dict docType;
}
