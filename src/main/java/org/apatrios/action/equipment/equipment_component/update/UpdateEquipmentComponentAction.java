package org.apatrios.action.equipment.equipment_component.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.EquipmentComponent;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.equipment.equipment_component.EquipmentComponentService;
import org.apatrios.service.equipment.equipment_component.argument.UpdateEquipmentComponentArgument;
import org.apatrios.service.dictionary.ComponentModelService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateEquipmentComponentAction implements Action<UpdateEquipmentComponentActionArgument, EquipmentComponent> {

    ComponentModelService componentModelService;
    EquipmentComponentService componentService;

    @Override
    public EquipmentComponent execute(@NonNull UpdateEquipmentComponentActionArgument argument) {
        ComponentModel componentModel = componentModelService.getExisting(argument.getComponentModelId());

        return componentService.update(argument.getId(),
                                       UpdateEquipmentComponentArgument.builder()
                                                                       .model(componentModel)
                                                                       .invNumber(argument.getInvNumber())
                                                                       .status(argument.getStatus())
                                                                       .comment(argument.getComment())
                                                                       .build());
    }
}
