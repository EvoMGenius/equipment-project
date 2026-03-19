package org.apatrios.service.equipment.iot;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.equipment.Iot;
import org.apatrios.model.equipment.IotStatus;
import org.apatrios.model.equipment.QIot;
import org.apatrios.repository.equipment.IotRepository;
import org.apatrios.service.equipment.iot.argument.CreateIotArgument;
import org.apatrios.service.equipment.iot.argument.SearchIotArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IotService {

    private final IotRepository repository;
    private final QIot qIot = QIot.iot;

    @Transactional
    public Iot create(@NonNull CreateIotArgument argument) {
        return repository.save(Iot.builder()
                                  .iotModel(argument.iotModel())
                                  .invNumber(argument.invNumber())
                                  .company(argument.company())
                                  .imei(argument.imei())
                                  .simId(argument.simId())
                                  .status(IotStatus.CREATED)
                                  .comment(argument.comment())
                                  .build());
    }

    @Transactional(readOnly = true)
    public Iot getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Iot.notFound"));
    }

    @Transactional(readOnly = true)
    public Page<Iot> page(@NonNull SearchIotArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchIotArgument argument) {
        return QPredicates.builder()
                          .add(argument.modelId(), qIot.iotModel.id::eq)
                          .add(argument.invNumber(), qIot.invNumber::containsIgnoreCase)
                          .add(argument.imei(), qIot.imei::containsIgnoreCase)
                          .add(argument.companyId(), qIot.company.id::eq)
                          .add(argument.status(), qIot.status::eq)
                          .add(argument.isDeleted(), qIot.isDeleted::eq)
                          .buildAnd();
    }
}