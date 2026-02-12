package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.dictoinary.QDict;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.DictRepository;
import org.apatrios.service.dictionary.argument.SearchDictArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictService extends BaseDictionaryService<Dict, SearchDictArgument, QDict> {

    private final DictRepository dictRepository;

    @Override
    protected BaseDictionaryRepository<Dict> getRepository() {
        return dictRepository;
    }

    @Override
    protected QDict getQRoot() {
        return QDict.dict;
    }
}
