package org.apatrios.action.services.recruit.create;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CreateRecruitActionArgument {
    String recruitCompanyName;
    UUID statusId;
}
