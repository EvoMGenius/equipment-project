package org.apatrios.service.equipment.sim.argument;

import lombok.Builder;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
@Builder
public class CreateSimArgument {
    String phoneNumber;
    Set<UUID> franchiseeIds;
}