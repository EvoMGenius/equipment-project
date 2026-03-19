package org.apatrios.action.management.doc.upload;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.management.doc.upload.argument.UploadDocumentActionArgument;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.model.dictoinary.DocType;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.File;
import org.apatrios.service.dictionary.DocTypeService;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.management.document.argument.CreateDocumentArgument;
import org.apatrios.service.storage.MinioFileService;
import org.apatrios.util.FileUrlSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UploadDocumentAction {

    MinioFileService minioFileService;
    DocumentService documentService;
    DocumentProperties documentProperties;
    FileUrlSerializer fileUrlSerializer;
    DocTypeService docTypeService;

    @Transactional
    public Document execute(@NonNull UploadDocumentActionArgument argument, @NonNull MultipartFile file) {
        DocType docType = docTypeService.getExisting(argument.docTypeId());
        String extension = fileUrlSerializer.getExtension(file.getOriginalFilename());
        String fileName = String.format("%s_%d.%s", argument.name(), System.currentTimeMillis(), extension);
        String url = minioFileService.upload(file, documentProperties.getDocFolder(), fileName);

        return documentService.create(CreateDocumentArgument.builder()
                                                            .name(argument.name())
                                                            .file(File.builder()
                                                                      .type(docType.getName())
                                                                      .url(url)
                                                                      .format(extension)
                                                                      .build())
                                                            .build());
    }
}
