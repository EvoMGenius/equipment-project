package org.apatrios.action.services.recruit.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.Recruit;
import org.apatrios.service.dictionary.ServiceDictionaryService;
import org.apatrios.service.services.client.ClientService;
import org.apatrios.service.services.recruit.RecruitService;
import org.apatrios.service.services.recruit.argument.UpdateRecruitArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateRecruitAction implements Action<UpdateRecruitActionArgument, Recruit> {

    ServiceDictionaryService serviceService;
    ClientService clientService;
    RecruitService recruitService;

    @Override
    @Transactional
    public Recruit execute(@NonNull UpdateRecruitActionArgument argument) {
        ServiceDictionary service = serviceService.getExisting(argument.getServiceId());
        Client client = clientService.getExisting(argument.getClientId());

        return recruitService.update(argument.getId(),
                                     UpdateRecruitArgument.builder()
                                                          .client(client)
                                                          .service(service)
                                                          .build());
    }
}
