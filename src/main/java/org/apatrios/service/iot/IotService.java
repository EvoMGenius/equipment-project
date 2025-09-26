package org.apatrios.service.iot;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.Iot;
import org.apatrios.model.QIot;
import org.apatrios.repository.IotRepository;
import org.apatrios.service.iot.argument.CreateIotArgument;
import org.apatrios.service.iot.argument.SearchIotArgument;
import org.apatrios.service.iot.argument.UpdateIotArgument;
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
public class IotService {
    private final IotRepository repository;

    private final QIot qIot = QIot.iot;

    @Transactional
    public Iot create(CreateIotArgument argument) {
        return repository.save(Iot.builder()
                                  .model(argument.getModel())
                                  .invNumber(argument.getInvNumber())
                                  .sim(argument.getSim())
                                  .status(argument.getStatus())
                                  .comment(argument.getComment())
                                  .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Iot update(UUID id, UpdateIotArgument argument) {
        Iot existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setSim(argument.getSim());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Iot> list(SearchIotArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Iot> page(SearchIotArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchIotArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelId(), qIot.model.id::eq)
                          .add(argument.getInvNumber(), qIot.invNumber::containsIgnoreCase)
                          .add(argument.getSimId(), qIot.sim.id::eq)
                          .add(argument.getStatus(), qIot.status::eq)
                          .add(argument.getComment(), qIot.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Iot getExisting(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private void delete(UUID id) {
        repository.deleteById(id);
    }
}