package org.apatrios.action.component.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.component.ComponentService;
import org.apatrios.service.component.argument.UpdateComponentArgument;
import org.apatrios.service.dictionary.ComponentModelService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateComponentAction implements Action<UpdateComponentActionArgument, org.apatrios.model.Component> {

    ComponentModelService componentModelService;
    ComponentService componentService;

    @Override
    public org.apatrios.model.Component execute(@NonNull UpdateComponentActionArgument argument) {
        ComponentModel componentModel = componentModelService.getExisting(argument.getComponentModelId());

        return componentService.update(argument.getId(),
                                       UpdateComponentArgument.builder()
                                                              .model(componentModel)
                                                              .invNumber(argument.getInvNumber())
                                                              .status(argument.getStatus())
                                                              .comment(argument.getComment())
                                                              .build());
    }
}
