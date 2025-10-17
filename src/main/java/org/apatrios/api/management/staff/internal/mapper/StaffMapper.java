package org.apatrios.api.management.staff.internal.mapper;

import org.apatrios.action.management.staff.create.CreateStaffActionArgument;
import org.apatrios.action.management.staff.update.UpdateStaffActionArgument;
import org.apatrios.api.management.staff.internal.dto.CreateStaffDto;
import org.apatrios.api.management.staff.internal.dto.SearchStaffDto;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.api.management.staff.internal.dto.UpdateStaffDto;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.staff.argument.SearchStaffArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper STAFF_MAPPER = Mappers.getMapper(StaffMapper.class);

    CreateStaffActionArgument toCreateArgument(CreateStaffDto dto);
    UpdateStaffActionArgument toUpdateArgument(UpdateStaffDto dto);
    SearchStaffArgument toSearchArgument(SearchStaffDto dto);
    StaffDto toDto(Staff staff);
}
