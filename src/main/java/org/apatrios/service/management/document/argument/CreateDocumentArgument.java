package org.apatrios.service.management.document.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.File;

@Value
@Builder
public class CreateDocumentArgument {
    Status status;

    String name;

    Dict docType;

    File file;
}
