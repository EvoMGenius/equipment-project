package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QModelBike;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ModelBikeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelBikeService extends SimpleDictionaryService<ModelBike> {

    private final ModelBikeRepository repository;

    @Override
    protected BaseDictionaryRepository<ModelBike> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QModelBike.modelBike._super;
    }
}
