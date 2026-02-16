package org.apatrios.api.dictionary.dict;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.dictionary.dict.dto.SearchDictDto;
import org.apatrios.api.dictionary.dict.mapper.DictMapper;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.dictionary.argument.SearchDictArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict")
public class DictController extends BaseDictionaryController<Dict, SearchDictArgument, SearchDictDto, DictDto> {

    private final DictService service;
    private final DictMapper mapper;

    @Override
    protected BaseDictionaryService<Dict, SearchDictArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<Dict, DictDto, SearchDictDto, SearchDictArgument> getMapper() {
        return mapper;
    }
}
