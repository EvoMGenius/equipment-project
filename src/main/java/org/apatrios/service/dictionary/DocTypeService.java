package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.DocType;
import org.apatrios.model.dictoinary.QDocType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.DocTypeRepository;
import org.apatrios.service.dictionary.argument.SearchDocTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocTypeService extends BaseDictionaryService<DocType, SearchDocTypeArgument, QDocType> {

    private final DocTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<DocType> getRepository() {
        return repository;
    }

    @Override
    protected QDocType getQRoot() {
        return QDocType.docType;
    }
}
