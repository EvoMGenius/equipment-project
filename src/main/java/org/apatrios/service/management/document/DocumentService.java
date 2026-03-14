package org.apatrios.service.management.document;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.DocumentStatus;
import org.apatrios.repository.managment.DocumentRepository;
import org.apatrios.service.management.document.argument.CreateDocumentArgument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    @Transactional
    public Document create(@NonNull CreateDocumentArgument argument) {
        return repository.save(Document.builder()
                                       .docType(argument.docType())
                                       .name(argument.name())
                                       .file(argument.file())
                                       .status(DocumentStatus.CREATED)
                                       .build());
    }

    @Transactional(readOnly = true)
    public Document getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Document.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Document> getAllByIds(@NonNull List<UUID> ids) {
        return repository.findAllById(ids);
    }
}
