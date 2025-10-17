package org.apatrios.service.equipment.outfit;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.equipment.OutfitStatus;
import org.apatrios.model.equipment.QOutfit;
import org.apatrios.repository.equipment.OutfitRepository;
import org.apatrios.service.equipment.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.equipment.outfit.argument.SearchOutfitArgument;
import org.apatrios.service.equipment.outfit.argument.UpdateOutfitArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.apatrios.exception.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutfitService {
    private final OutfitRepository repository;

    private final QOutfit qOutfit = QOutfit.outfit;

    @Transactional
    public Outfit create(@NonNull CreateOutfitArgument argument) {
        return repository.save(Outfit.builder()
                                     .model(argument.getModel())
                                     .invNumber(argument.getInvNumber())
                                     .status(OutfitStatus.ACTIVE)
                                     .comment(argument.getComment())
                                     .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Outfit update(@NonNull UUID id, @NonNull UpdateOutfitArgument argument) {
        Outfit existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Outfit> list(@NonNull SearchOutfitArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Outfit> page(@NonNull SearchOutfitArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchOutfitArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelId(), qOutfit.model.id::eq)
                          .add(argument.getInvNumber(), qOutfit.invNumber::eq)
                          .add(argument.getStatus(), qOutfit.status::eq)
                          .add(argument.getComment(), qOutfit.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Outfit getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Outfit.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}