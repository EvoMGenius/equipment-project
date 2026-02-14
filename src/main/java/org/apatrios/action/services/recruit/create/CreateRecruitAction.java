package org.apatrios.action.services.recruit.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.services.Recruit;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.services.recruit.RecruitService;
import org.apatrios.service.services.recruit.argument.CreateRecruitArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateRecruitAction implements Action<CreateRecruitActionArgument, Recruit> {

    RecruitService recruitService;
    StatusService statusService;

    @Override
    @Transactional
    public Recruit execute(@NonNull CreateRecruitActionArgument argument) {
        Status status = statusService.getExisting(argument.getStatusId());
        return recruitService.create(CreateRecruitArgument.builder()
                                                          .status(status)
                                                          .recruitCompanyName(argument.getRecruitCompanyName())
                                                          .build());
    }
}
