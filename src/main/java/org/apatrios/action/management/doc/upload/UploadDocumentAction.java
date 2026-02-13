package org.apatrios.action.management.doc.upload;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.File;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UploadDocumentAction {

    MinioFileService minioFileService;
    DocumentService documentService;
    DocumentProperties documentProperties;

    @Transactional
    public void execute(@NonNull UUID id, @NonNull MultipartFile file) {
        Document document = documentService.getExisting(id);
        String extension = minioFileService.getExtension(file.getOriginalFilename());
        String fileName = document.getId().toString() + "." + extension;
        minioFileService.upload(file, documentProperties.getDocFolder(), fileName);

        documentService.setFileInfo(id, File.builder()
                                            .type("DOCUMENT")
                                            .format(extension)
                                            .build());
    }
}
