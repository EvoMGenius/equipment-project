package org.apatrios.service.outfit;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.Outfit;
import org.apatrios.model.QOutfit;
import org.apatrios.repository.OutfitRepository;
import org.apatrios.service.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.outfit.argument.SearchOutfitArgument;
import org.apatrios.service.outfit.argument.UpdateOutfitArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutfitService {
    private final OutfitRepository repository;

    private final QOutfit qOutfit = QOutfit.outfit;

    @Transactional
    public Outfit create(CreateOutfitArgument argument) {
        return repository.save(Outfit.builder()
                                     .model(argument.getModel())
                                     .invNumber(argument.getInvNumber())
                                     .status(argument.getStatus())
                                     .comment(argument.getComment())
                                     .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Outfit update(UUID id, UpdateOutfitArgument argument) {
        Outfit existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Outfit> list(SearchOutfitArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Outfit> page(SearchOutfitArgument argument, Pageable pageable) {
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
    public Outfit getExisting(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private void delete(UUID id) {
        repository.deleteById(id);
    }
}