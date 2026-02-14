package org.apatrios.service.management.document.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.management.File;

import java.util.UUID;

@Value
@Builder
public class SearchDocumentArgument {
    UUID statusId;

    String name;

    UUID docTypeId;

    File file;
}
