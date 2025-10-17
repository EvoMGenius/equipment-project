package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.model.services.Client;

@Value
@Builder
public class UpdateRecruitArgument {
    ServiceDictionary service;

    Client client;
}
