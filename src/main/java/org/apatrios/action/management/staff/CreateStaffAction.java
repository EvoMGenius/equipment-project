package org.apatrios.action.management.staff;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.action.management.staff.argument.CreateStaffActionArgument;
import org.apatrios.model.management.Company;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.company.CompanyService;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.staff.argument.CreateStaffArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateStaffAction implements Action<CreateStaffActionArgument, Staff> {

    private final StaffService staffService;
    private final CompanyService companyService;

    @Override
    @Transactional
    public Staff execute(@NonNull CreateStaffActionArgument argument) {
        Company company = companyService.getExisting(argument.companyId());

        return staffService.create(CreateStaffArgument.builder()
                                                      .name(argument.name())
                                                      .phone(argument.phone())
                                                      .email(argument.email())
                                                      .company(company)
                                                      .position(argument.position())
                                                      .surname(argument.surname())
                                                      .build());
    }
}
