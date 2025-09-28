package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.QOutfit;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QOutfitModel;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.OutfitModelRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutfitModelService extends SimpleDictionaryService<OutfitModel> {

    private final OutfitModelRepository repository;

    @Override
    protected BaseDictionaryRepository<OutfitModel> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QOutfitModel.outfitModel._super;
    }
}
