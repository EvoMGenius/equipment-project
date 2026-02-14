package org.apatrios.api.management.doc.mapper;

import org.apatrios.action.management.doc.create.argument.CreateDocumentActionArgument;
import org.apatrios.api.management.doc.dto.CreateDocumentDto;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.doc.dto.SearchDocumentDto;
import org.apatrios.model.management.Document;
import org.apatrios.service.management.document.argument.SearchDocumentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper DOCUMENT_MAPPER = Mappers.getMapper(DocumentMapper.class);

    SearchDocumentArgument toSearchArgument(SearchDocumentDto dto);
    DocumentDto toDto(Document document);
    CreateDocumentActionArgument toCreateArgument(CreateDocumentDto dto);
}
