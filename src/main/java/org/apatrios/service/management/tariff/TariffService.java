package org.apatrios.service.management.tariff;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.QTariff;
import org.apatrios.model.management.Tariff;
import org.apatrios.repository.managment.TariffRepository;
import org.apatrios.service.management.tariff.argument.CreateTariffArgument;
import org.apatrios.service.management.tariff.argument.SearchTariffArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TariffService {

    private final TariffRepository repository;
    private final QTariff qTariff = QTariff.tariff;

    @Transactional
    public Tariff create(@NonNull CreateTariffArgument argument) {
        return repository.save(Tariff.builder()
                                     .code(argument.getCode())
                                     .tariffType(argument.getTariffType())
                                     .startBorder(argument.getStartBorder())
                                     .endBorder(argument.getEndBorder())
                                     .sale(argument.getSale())
                                     .cost(argument.getCost())
                                     .status(argument.getStatus())
                                     .build());
    }

    @Transactional(readOnly = true)
    public Tariff getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Tariff.notFound"));
    }

    @Transactional(readOnly = true)
    public List<Tariff> getAllByIds(@NonNull List<UUID> ids) {
        return repository.findAllById(ids);
    }

    @Transactional(readOnly = true)
    public List<Tariff> list(@NonNull SearchTariffArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    private Predicate buildPredicate(SearchTariffArgument argument) {
        return QPredicates.builder()
                          .add(argument.getCode(), qTariff.code::eq)
                          .add(argument.getSale(), qTariff.sale::eq)
                          .add(argument.getCost(), qTariff.cost::eq)
                          .add(argument.getTariffTypeId(), qTariff.tariffType.id::eq)
                          .add(argument.getStatusId(), qTariff.status.id::eq)
                          .add(argument.getStartBorder(), qTariff.startBorder::goe)
                          .add(argument.getEndBorder(), qTariff.endBorder::loe)
                          .buildAnd();
    }
}
