package org.apatrios.service.simbalance;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.SimBalance;
import org.apatrios.model.QSimBalance;
import org.apatrios.repository.SimBalanceRepository;
import org.apatrios.service.simbalance.argument.CreateSimBalanceArgument;
import org.apatrios.service.simbalance.argument.SearchSimBalanceArgument;
import org.apatrios.service.simbalance.argument.UpdateSimBalanceArgument;
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
public class SimBalanceService {
    private final SimBalanceRepository repository;

    private final QSimBalance qSimBalance = QSimBalance.simBalance;

    @Transactional
    public SimBalance create(CreateSimBalanceArgument argument) {
        return repository.save(SimBalance.builder()
                                         .value(argument.getValue())
                                         .sim(argument.getSim())
                                         .createDate(argument.getCreateDate())
                                         .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public SimBalance update(UUID id, UpdateSimBalanceArgument argument) {
        SimBalance existing = getExisting(id);

        existing.setValue(argument.getValue());
        existing.setSim(argument.getSim());
        existing.setCreateDate(argument.getCreateDate());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<SimBalance> list(SearchSimBalanceArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<SimBalance> page(SearchSimBalanceArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchSimBalanceArgument argument) {
        return QPredicates.builder()
                          .add(argument.getValue(), qSimBalance.value::eq)
                          .add(argument.getSimId(), qSimBalance.sim.id::eq)
                          .add(argument.getCreateDateFrom(), qSimBalance.createDate::goe)
                          .add(argument.getCreateDateTo(), qSimBalance.createDate::loe)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public SimBalance getExisting(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private void delete(UUID id) {
        repository.deleteById(id);
    }
}