package org.apatrios.action.component.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ComponentModel;
import org.apatrios.service.component.ComponentService;
import org.apatrios.service.component.argument.CreateComponentArgument;
import org.apatrios.service.dictionary.ComponentModelService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateComponentAction implements Action<CreateComponentActionArgument, org.apatrios.model.Component> {

    ComponentModelService componentModelService;
    ComponentService componentService;

    @Override
    @Transactional
    public org.apatrios.model.Component execute(@NonNull CreateComponentActionArgument argument) {
        ComponentModel componentModel = componentModelService.getExisting(argument.getComponentModelId());

        return componentService.create(CreateComponentArgument.builder()
                                                              .model(componentModel)
                                                              .invNumber(argument.getInvNumber())
                                                              .status(argument.getStatus())
                                                              .comment(argument.getComment())
                                                              .build());
    }
}
