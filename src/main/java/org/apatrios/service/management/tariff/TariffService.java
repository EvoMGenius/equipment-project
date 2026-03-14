package org.apatrios.service.management.tariff;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.QTariff;
import org.apatrios.model.management.Tariff;
import org.apatrios.model.management.TariffStatus;
import org.apatrios.repository.managment.TariffRepository;
import org.apatrios.service.management.tariff.argument.CreateTariffArgument;
import org.apatrios.service.management.tariff.argument.SearchTariffArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                                     .code(argument.code())
                                     .tariffType(argument.tariffType())
                                     .paymentFrequency(argument.paymentFrequency())
                                     .installmentAmount(argument.installmentAmount())
                                     .installmentCount(argument.installmentCount())
                                     .startBorder(argument.startBorder())
                                     .endBorder(argument.endBorder())
                                     .sale(argument.sale())
                                     .cost(argument.cost())
                                     .customPrice(argument.customPrice())
                                     .status(TariffStatus.CREATED)
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
    public Page<Tariff> page(@NonNull SearchTariffArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchTariffArgument argument) {
        return QPredicates.builder()
                          .add(argument.code(), qTariff.code::eq)
                          .add(argument.paymentFrequency(), qTariff.paymentFrequency::eq)
                          .add(argument.installmentAmount(), qTariff.installmentAmount::eq)
                          .add(argument.installmentCount(), qTariff.installmentCount::eq)
                          .add(argument.sale(), qTariff.sale::eq)
                          .add(argument.cost(), qTariff.cost::eq)
                          .add(argument.customPrice(), qTariff.customPrice::eq)
                          .add(argument.tariffTypeId(), qTariff.tariffType.id::eq)
                          .add(argument.status(), qTariff.status::eq)
                          .add(argument.startBorder(), qTariff.startBorder::goe)
                          .add(argument.endBorder(), qTariff.endBorder::loe)
                          .buildAnd();
    }
}
