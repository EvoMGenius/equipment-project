package org.apatrios.api.management.doc.mapper;

import org.apatrios.action.management.doc.upload.argument.UploadDocumentActionArgument;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.management.doc.dto.UploadDocumentDto;
import org.apatrios.model.management.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper DOCUMENT_MAPPER = Mappers.getMapper(DocumentMapper.class);
    DocumentDto toDto(Document document);
    UploadDocumentActionArgument toUploadArgument(UploadDocumentDto dto);
}
