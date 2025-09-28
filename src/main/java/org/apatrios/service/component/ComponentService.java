package org.apatrios.service.component;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.Component;
import org.apatrios.model.QComponent;
import org.apatrios.repository.ComponentRepository;
import org.apatrios.service.component.argument.CreateComponentArgument;
import org.apatrios.service.component.argument.SearchComponentArgument;
import org.apatrios.service.component.argument.UpdateComponentArgument;
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
public class ComponentService {

    private final ComponentRepository repository;
    private final QComponent qComponent = QComponent.component;

    @Transactional
    public Component create(@NonNull CreateComponentArgument argument) {
        return repository.save(Component.builder()
                                        .model(argument.getModel())
                                        .invNumber(argument.getInvNumber())
                                        .status(argument.getStatus())
                                        .comment(argument.getComment())
                                        .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Component update(@NonNull UUID id, @NonNull UpdateComponentArgument argument) {
        Component existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Component> list(@NonNull SearchComponentArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Component> page(@NonNull SearchComponentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchComponentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelId(), qComponent.model.id::eq)
                          .add(argument.getInvNumber(), qComponent.invNumber::eq)
                          .add(argument.getStatus(), qComponent.status::containsIgnoreCase)
                          .add(argument.getComment(), qComponent.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Component getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Component.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}