package org.apatrios.service.dictionary;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.QModelBike;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.ModelBikeRepository;
import org.apatrios.service.dictionary.argument.SearchModelBikeArgument;
import org.apatrios.util.QPredicates;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelBikeService extends BaseDictionaryService<ModelBike, SearchModelBikeArgument, QModelBike> {

    private final ModelBikeRepository repository;

    @Override
    protected BaseDictionaryRepository<ModelBike> getRepository() {
        return repository;
    }

    @Override
    protected QModelBike getQRoot() {
        return QModelBike.modelBike;
    }

    @Override
    protected Predicate buildPredicates(@NonNull SearchModelBikeArgument argument) {
        QModelBike qModel = getQRoot();
        return QPredicates.builder()
                          .add(super.buildPredicates(argument))
                          .add(argument.getMaxSpeed(), qModel.maxSpeed::containsIgnoreCase)
                          .add(argument.getRange(), qModel.range::containsIgnoreCase)
                          .add(argument.getWeight(), qModel.weight::containsIgnoreCase)
                          .add(argument.getMaxLoad(), qModel.maxLoad::containsIgnoreCase)
                          .add(argument.getPhotoIds(), qModel.photo.any().id::in)
                          .buildAnd();
    }
}
