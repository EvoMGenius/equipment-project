package org.apatrios.service.management.document.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;

@Value
@Builder
public class CreateDocumentArgument {
    Status status;

    String name;

    Dict docType;
}
