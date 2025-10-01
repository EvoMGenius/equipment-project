package org.apatrios.action.management.staff.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.staff.argument.UpdateStaffArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateStaffAction implements Action<UpdateStaffActionArgument, Staff> {

    FranchiseeService franchiseeService;
    StaffService staffService;

    @Override
    @Transactional
    public Staff execute(@NonNull UpdateStaffActionArgument argument) {
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return staffService.update(argument.getId(),
                                   UpdateStaffArgument.builder()
                                                      .franchisee(franchisee)
                                                      .position(argument.getPosition())
                                                      .staffProfile(argument.getStaffProfile())
                                                      .status(argument.getStatus())
                                                      .build());
    }
}
