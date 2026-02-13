package org.apatrios.action.management.doc.create.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateDocumentActionArgument {
    UUID statusId;

    String name;

    UUID docTypeId;
}
