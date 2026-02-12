package org.apatrios.action.management.doc.download;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Document;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DownloadDocumentAction implements Action<UUID, InputStream> {

    MinioFileService minioFileService;
    DocumentService documentService;

    @Override
    public InputStream execute(@NonNull UUID id) {
        Document document = documentService.getExisting(id);
        String filePath = "documents/" + document.getId().toString();
        return minioFileService.getStream(filePath);
    }
}
