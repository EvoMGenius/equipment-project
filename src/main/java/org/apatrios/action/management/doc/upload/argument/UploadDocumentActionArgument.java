package org.apatrios.action.management.doc.upload.argument;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UploadDocumentActionArgument(
        String name,
        UUID docTypeId
) {}
