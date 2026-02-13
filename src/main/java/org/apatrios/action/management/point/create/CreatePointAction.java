package org.apatrios.action.management.point.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Point;
import org.apatrios.service.dictionary.DictService;
import org.apatrios.service.equipment.status.StatusService;
import org.apatrios.service.management.point.PointService;
import org.apatrios.service.management.point.argument.CreatePointArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreatePointAction implements Action<CreatePointActionArgument, Point> {

    PointService pointService;
    DictService dictService;
    StatusService statusService;

    @Override
    @Transactional
    public Point execute(@NonNull CreatePointActionArgument argument) {
        Dict dict = dictService.getExisting(argument.getPointTypeId());
        Status status = statusService.getExisting(argument.getStatusId());

        return pointService.create(CreatePointArgument.builder()
                                                      .pointType(dict)
                                                      .name(argument.getName())
                                                      .number(argument.getNumber())
                                                      .address(argument.getAddress())
                                                      .workTime(argument.getWorkTime())
                                                      .status(status)
                                                      .build());
    }
}
