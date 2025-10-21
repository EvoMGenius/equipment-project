package org.apatrios.service.equipment.sim;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.Sim;
import org.apatrios.model.equipment.QSim;
import org.apatrios.repository.equipment.SimRepository;
import org.apatrios.service.equipment.sim.argument.CreateSimArgument;
import org.apatrios.service.equipment.sim.argument.SearchSimArgument;
import org.apatrios.service.equipment.sim.argument.UpdateSimArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.apatrios.exception.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SimService {
    private final SimRepository repository;

    private final QSim qSim = QSim.sim;

    @Transactional
    public Sim create(@NonNull CreateSimArgument argument) {
        return repository.save(Sim.builder()
                                  .phoneNumber(argument.getPhoneNumber())
                                  .createDate(LocalDateTime.now())
                                  .updateDate(LocalDateTime.now())
                                  .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Sim update(@NonNull UUID id, @NonNull UpdateSimArgument argument) {
        Sim existing = getExisting(id);

        existing.setPhoneNumber(argument.getPhoneNumber());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Sim> list(@NonNull SearchSimArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Sim> page(@NonNull SearchSimArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchSimArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPhoneNumber(), qSim.phoneNumber::containsIgnoreCase)
                          .add(argument.isDeleted(), qSim.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qSim.createDate::goe)
                          .add(argument.getCreateDateTo(), qSim.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qSim.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qSim.updateDate::loe)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Sim getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sim.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}