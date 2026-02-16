package org.apatrios.service.management.document.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.DocumentStatus;
import org.apatrios.model.management.File;

import java.util.UUID;

@Value
@Builder
public class SearchDocumentArgument {
    DocumentStatus status;

    String name;

    UUID docTypeId;

    File file;
}
