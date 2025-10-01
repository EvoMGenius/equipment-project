package org.apatrios.action.management.staff.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.staff.argument.CreateStaffArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateStaffAction implements Action<CreateStaffActionArgument, Staff> {

    FranchiseeService franchiseeService;
    StaffService staffService;

    @Override
    @Transactional
    public Staff execute(@NonNull CreateStaffActionArgument argument) {
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());

        return staffService.create(CreateStaffArgument.builder()
                                                      .franchisee(franchisee)
                                                      .staffProfile(argument.getStaffProfile())
                                                      .position(argument.getPosition())
                                                      .build());
    }
}
