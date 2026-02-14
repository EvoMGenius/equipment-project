package org.apatrios.service.services.recruit.argument;

import lombok.Builder;
import lombok.Value;
import org.apatrios.model.equipment.Status;

@Value
@Builder
public class CreateRecruitArgument {
    String recruitCompanyName;
    Status status;
}
