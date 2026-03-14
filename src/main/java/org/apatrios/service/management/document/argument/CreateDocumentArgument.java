package org.apatrios.service.management.document.argument;

import lombok.Builder;
import org.apatrios.model.dictoinary.DocType;
import org.apatrios.model.management.File;

@Builder
public record CreateDocumentArgument(
        String name,
        File file,
        DocType docType
) {}