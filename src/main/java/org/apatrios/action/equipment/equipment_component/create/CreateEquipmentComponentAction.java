package org.apatrios.action.equipment.equipment_component.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.EquipmentComponent;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.equipment.equipment_component.EquipmentComponentService;
import org.apatrios.service.equipment.equipment_component.argument.CreateEquipmentComponentArgument;
import org.apatrios.service.dictionary.ComponentModelService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateEquipmentComponentAction implements Action<CreateEquipmentComponentActionArgument, EquipmentComponent> {

    ComponentModelService componentModelService;
    EquipmentComponentService componentService;

    @Override
    @Transactional
    public EquipmentComponent execute(@NonNull CreateEquipmentComponentActionArgument argument) {
        ComponentModel componentModel = componentModelService.getExisting(argument.getComponentModelId());

        return componentService.create(CreateEquipmentComponentArgument.builder()
                                                                       .model(componentModel)
                                                                       .invNumber(argument.getInvNumber())
                                                                       .comment(argument.getComment())
                                                                       .franchiseeIds(argument.getFranchiseeIds())
                                                                       .build());
    }
}