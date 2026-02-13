package org.apatrios.action.management.doc.download;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.model.management.Document;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DownloadDocumentAction implements Action<UUID, InputStreamResource> {

    MinioFileService minioFileService;
    DocumentService documentService;
    DocumentProperties documentProperties;

    @Override
    public InputStreamResource execute(@NonNull UUID id) {
        Document document = documentService.getExisting(id);
        InputStream stream = minioFileService.getStream(String.format("%s/%s.%s", documentProperties.getDocFolder(), document.getId(), document.getFile().getFormat()));

        return new InputStreamResource(stream, document.getId().toString() + "." + document.getFile().getFormat());
    }
}
