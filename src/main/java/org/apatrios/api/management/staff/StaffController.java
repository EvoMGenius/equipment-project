package org.apatrios.api.management.staff;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.staff.argument.CreateStaffActionArgument;
import org.apatrios.api.management.staff.dto.CreateStaffDto;
import org.apatrios.api.management.staff.dto.SearchStaffDto;
import org.apatrios.api.management.staff.dto.StaffDto;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.management.staff.mapper.StaffMapper.STAFF_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/management/staff")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StaffController {

    StaffService service;
    Action<CreateStaffActionArgument, Staff> createStaffAction;

    @PostMapping
    public StaffDto create(@Valid @RequestBody CreateStaffDto dto) {
        return STAFF_MAPPER.toDto(createStaffAction.execute(STAFF_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public StaffDto get(@PathVariable UUID id) {
        return STAFF_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<StaffDto> page(SearchStaffDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(STAFF_MAPPER.toSearchArgument(dto), pageable)
                                       .map(STAFF_MAPPER::toDto));
    }
}