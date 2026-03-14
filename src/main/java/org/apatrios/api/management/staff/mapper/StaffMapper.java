package org.apatrios.api.management.staff.mapper;

import org.apatrios.action.management.staff.argument.CreateStaffActionArgument;
import org.apatrios.api.management.staff.dto.CreateStaffDto;
import org.apatrios.api.management.staff.dto.SearchStaffDto;
import org.apatrios.api.management.staff.dto.StaffDto;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.staff.argument.SearchStaffArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper STAFF_MAPPER = Mappers.getMapper(StaffMapper.class);
    StaffDto toDto(Staff staff);
    SearchStaffArgument toSearchArgument(SearchStaffDto dto);
    CreateStaffActionArgument toCreateArgument(CreateStaffDto dto);
}
