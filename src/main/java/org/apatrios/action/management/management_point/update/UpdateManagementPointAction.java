package org.apatrios.action.management.management_point.update;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Franchisee;
import org.apatrios.model.management.ManagementPoint;
import org.apatrios.service.dictionary.PointTypeService;
import org.apatrios.service.management.franchisee.FranchiseeService;
import org.apatrios.service.management.management_point.ManagementPointService;
import org.apatrios.service.management.management_point.argument.UpdateManagementPointArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateManagementPointAction implements Action<UpdateManagementPointActionArgument, ManagementPoint> {

    ManagementPointService managementPointService;
    FranchiseeService franchiseeService;
    PointTypeService pointTypeService;

    @Override
    @Transactional
    public ManagementPoint execute(@NonNull UpdateManagementPointActionArgument argument) {
        Franchisee franchisee = franchiseeService.getExisting(argument.getFranchiseeId());
        PointType pointType = pointTypeService.getExisting(argument.getPointTypeId());

        return managementPointService.update(argument.getId(),
                                             UpdateManagementPointArgument.builder()
                                                                .franchisee(franchisee)
                                                                .pointType(pointType)
                                                                .name(argument.getName())
                                                                .address(argument.getAddress())
                                                                .longitude(argument.getLongitude())
                                                                .latitude(argument.getLatitude())
                                                                .status(argument.getStatus())
                                                                .build());
    }
}
