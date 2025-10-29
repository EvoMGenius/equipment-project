package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.dictoinary.ServiceDictionary;
import org.apatrios.model.services.Client;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class UpdateRecruitArgument {
    Client client;
    Set<UUID> franchiseeIds;
}
