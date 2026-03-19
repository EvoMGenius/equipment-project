package org.apatrios.api.dictionary.doc_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.doc_type.dto.DocTypeDto;
import org.apatrios.api.dictionary.doc_type.dto.SearchDocTypeDto;
import org.apatrios.api.dictionary.doc_type.mapper.DocTypeMapper;
import org.apatrios.model.dictoinary.DocType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.DocTypeService;
import org.apatrios.service.dictionary.argument.SearchDocTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/docType")
public class DocTypeController extends BaseDictionaryController<DocType, SearchDocTypeArgument, SearchDocTypeDto, DocTypeDto> {

    private final DocTypeService service;
    private final DocTypeMapper mapper;

    @Override
    protected BaseDictionaryService<DocType, SearchDocTypeArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<DocType, DocTypeDto, SearchDocTypeDto, SearchDocTypeArgument> getMapper() {
        return mapper;
    }
}
