package org.apatrios.service.equipment.equipment_component;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.model.equipment.EquipmentComponent;
import org.apatrios.model.equipment.EquipmentComponentStatus;
import org.apatrios.model.equipment.QEquipmentComponent;
import org.apatrios.repository.equipment.EquipmentComponentRepository;
import org.apatrios.service.equipment.equipment_component.argument.CreateEquipmentComponentArgument;
import org.apatrios.service.equipment.equipment_component.argument.SearchEquipmentComponentArgument;
import org.apatrios.service.equipment.equipment_component.argument.UpdateEquipmentComponentArgument;
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
public class EquipmentComponentService {

    private final EquipmentComponentRepository repository;
    private final QEquipmentComponent qEquipmentComponent = QEquipmentComponent.equipmentComponent;

    @Transactional
    public EquipmentComponent create(@NonNull CreateEquipmentComponentArgument argument) {
        return repository.save(EquipmentComponent.builder()
                                                 .model(argument.getModel())
                                                 .invNumber(argument.getInvNumber())
                                                 .status(EquipmentComponentStatus.NEW)
                                                 .comment(argument.getComment())
                                                 .createDate(LocalDateTime.now())
                                                 .updateDate(LocalDateTime.now())
                                                 .franchiseeIds(argument.getFranchiseeIds())
                                                 .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public EquipmentComponent update(@NonNull UUID id, @NonNull UpdateEquipmentComponentArgument argument) {
        EquipmentComponent existing = getExisting(id);

        existing.setModel(argument.getModel());
        existing.setInvNumber(argument.getInvNumber());
        existing.setStatus(argument.getStatus());
        existing.setComment(argument.getComment());
        existing.setStatus(argument.getStatus());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<EquipmentComponent> list(@NonNull SearchEquipmentComponentArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<EquipmentComponent> page(@NonNull SearchEquipmentComponentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchEquipmentComponentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getModelId(), qEquipmentComponent.model.id::eq)
                          .add(argument.getInvNumber(), qEquipmentComponent.invNumber::eq)
                          .add(argument.getStatus(), qEquipmentComponent.status::eq)
                          .add(argument.getComment(), qEquipmentComponent.comment::containsIgnoreCase)
                          .add(argument.getCreateDateFrom(), qEquipmentComponent.createDate::goe)
                          .add(argument.getCreateDateTo(), qEquipmentComponent.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qEquipmentComponent.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qEquipmentComponent.updateDate::loe)
                          .add(argument.isDeleted(), qEquipmentComponent.isDeleted::eq)
                          .add(argument.getFranchiseeIds(), qEquipmentComponent.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qEquipmentComponent.status.stringValue()::containsIgnoreCase,
                                        qEquipmentComponent.model.name::containsIgnoreCase,
                                        qEquipmentComponent.invNumber.stringValue()::containsIgnoreCase,
                                        qEquipmentComponent.comment::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public EquipmentComponent getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Component.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }
}