package org.apatrios.api.dictionary.doc_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.doc_type.dto.DocTypeDto;
import org.apatrios.api.dictionary.doc_type.dto.SearchDocTypeDto;
import org.apatrios.model.dictoinary.DocType;
import org.apatrios.service.dictionary.argument.SearchDocTypeArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocTypeMapper extends BaseDictionaryMapper<DocType, DocTypeDto, SearchDocTypeDto, SearchDocTypeArgument> {
}
