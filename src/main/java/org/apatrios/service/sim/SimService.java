package org.apatrios.service.sim;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.Sim;
import org.apatrios.model.QSim;
import org.apatrios.repository.SimRepository;
import org.apatrios.service.sim.argument.CreateSimArgument;
import org.apatrios.service.sim.argument.SearchSimArgument;
import org.apatrios.service.sim.argument.UpdateSimArgument;
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
public class SimService {
    private final SimRepository repository;

    private final QSim qSim = QSim.sim;

    @Transactional
    public Sim create(CreateSimArgument argument) {
        return repository.save(Sim.builder()
                                  .phoneNumber(argument.getPhoneNumber())
                                  .operator(argument.getOperator())
                                  .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Sim update(UUID id, UpdateSimArgument argument) {
        Sim existing = getExisting(id);

        existing.setPhoneNumber(argument.getPhoneNumber());
        existing.setOperator(argument.getOperator());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Sim> list(SearchSimArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Sim> page(SearchSimArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchSimArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPhoneNumber(), qSim.phoneNumber::containsIgnoreCase)
                          .add(argument.getOperatorId(), qSim.operator.id::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Sim getExisting(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private void delete(UUID id) {
        repository.deleteById(id);
    }
}