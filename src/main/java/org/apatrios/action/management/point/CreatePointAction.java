package org.apatrios.action.management.point;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.point.argument.CreatePointActionArgument;
import org.apatrios.model.dictoinary.PointType;
import org.apatrios.model.management.Company;
import org.apatrios.model.management.Point;
import org.apatrios.service.dictionary.PointTypeService;
import org.apatrios.service.management.company.CompanyService;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.management.point.argument.CreatePointArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreatePointAction implements Action<CreatePointActionArgument, Point> {

    PointService pointService;
    CompanyService companyService;
    PointTypeService pointTypeService;

    @Override
    @Transactional
    public Point execute(@NonNull CreatePointActionArgument argument) {
        PointType type = pointTypeService.getExisting(argument.pointTypeId());
        Company company = companyService.getExisting(argument.companyId());

        return pointService.create(CreatePointArgument.builder()
                                                      .name(argument.name())
                                                      .address(argument.address())
                                                      .company(company)
                                                      .pointType(type)
                                                      .latitude(argument.latitude())
                                                      .longitude(argument.longitude())
                                                      .build());
    }
}
