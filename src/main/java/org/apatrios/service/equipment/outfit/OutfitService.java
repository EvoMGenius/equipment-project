package org.apatrios.service.equipment.outfit;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.equipment.QOutfit;
import org.apatrios.repository.equipment.OutfitRepository;
import org.apatrios.service.equipment.outfit.argument.CreateOutfitArgument;
import org.apatrios.service.equipment.outfit.argument.SearchOutfitArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
                                     .chosenTariff(argument.getChosenTariff())
                                     .name(argument.getName())
                                     .status(argument.getStatus())
                                     .tariff(argument.getTariff())
                                     .build());
    }

    @Transactional(readOnly = true)
    public List<Outfit> list(@NonNull SearchOutfitArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchOutfitArgument argument) {
        return QPredicates.builder()
                          .add(argument.getChosenTariffId(), qOutfit.chosenTariff.id::eq)
                          .add(argument.getStatusId(), qOutfit.status.id::eq)
                          .add(argument.getName(), qOutfit.name::containsIgnoreCase)
                          .add(argument.getTariffIds(), qOutfit.tariff.any().id::in)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Outfit getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Outfit.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Outfit> getAllByIds(@NonNull List<UUID> ids) {
        return repository.findAllById(ids);
    }
}