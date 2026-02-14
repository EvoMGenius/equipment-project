package org.apatrios.action.management.doc.create.argument;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Document;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.document.DocumentService;
import org.apatrios.service.management.document.argument.CreateDocumentArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateDocumentAction implements Action<CreateDocumentActionArgument, Document> {

    private final DocumentService documentService;
    private final DictService dictService;
    private final StatusService statusService;

    @Override
    @Transactional
    public Document execute(@NonNull CreateDocumentActionArgument argument) {
        Status status = statusService.getExisting(argument.getStatusId());
        Dict dict = dictService.getExisting(argument.getDocTypeId());
        return documentService.create(CreateDocumentArgument.builder()
                                                            .name(argument.getName())
                                                            .docType(dict)
                                                            .status(status)
                                                            .build());
    }
}
