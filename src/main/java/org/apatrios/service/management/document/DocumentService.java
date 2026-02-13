package org.apatrios.service.management.document;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.File;
import org.apatrios.model.management.QDocument;
import org.apatrios.repository.managment.DocumentRepository;
import org.apatrios.service.management.document.argument.CreateDocumentArgument;
import org.apatrios.service.management.document.argument.SearchDocumentArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;
    private final QDocument qDocument = QDocument.document;

    @Transactional
    public Document create(@NonNull CreateDocumentArgument argument) {
        return repository.save(Document.builder()
                                       .docType(argument.getDocType())
                                       .name(argument.getName())
                                       .status(argument.getStatus())
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

    @Transactional
    public void setFileInfo(@NonNull UUID id, @NonNull File file) {
        Document document = getExisting(id);
        document.setFile(file);
        repository.save(document);
    }

    @Transactional(readOnly = true)
    public List<Document> list(@NonNull SearchDocumentArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchDocumentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getName(), qDocument.name::containsIgnoreCase)
                          .add(argument.getFile(), qDocument.file::eq)
                          .add(argument.getStatusId(), qDocument.status.id::eq)
                          .add(argument.getDocTypeId(), qDocument.docType.id::eq)
                          .buildAnd();
    }
}
