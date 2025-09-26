package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.repository.dictionary.DictionaryRepository;
import org.apatrios.repository.dictionary.ModelBikeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelBikeService extends DictionaryService<ModelBike> {

    private final ModelBikeRepository repository;

    @Override
    protected DictionaryRepository<ModelBike> getRepository() {
        return this.repository;
    }
}
