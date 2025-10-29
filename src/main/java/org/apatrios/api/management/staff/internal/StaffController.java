package org.apatrios.api.management.staff.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.staff.create.CreateStaffActionArgument;
import org.apatrios.action.management.staff.update.UpdateStaffActionArgument;
import org.apatrios.api.management.staff.internal.dto.CreateStaffDto;
import org.apatrios.api.management.staff.internal.dto.SearchStaffDto;
import org.apatrios.api.management.staff.internal.dto.StaffDto;
import org.apatrios.api.management.staff.internal.dto.UpdateStaffDto;
import org.apatrios.model.management.Staff;
import org.apatrios.service.management.staff.StaffService;
import org.apatrios.service.management.staff.argument.SearchStaffArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.staff.internal.mapper.StaffMapper.STAFF_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/staff")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StaffController {

    StaffService service;
    Action<CreateStaffActionArgument, Staff> createStaffAction;
    Action<UpdateStaffActionArgument, Staff> updateStaffAction;

    @PostMapping("create")
    public StaffDto create(@Valid @RequestBody CreateStaffDto dto) {
        return STAFF_MAPPER.toDto(createStaffAction.execute(STAFF_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public StaffDto update(@Valid @RequestBody UpdateStaffDto dto) {
        return STAFF_MAPPER.toDto(updateStaffAction.execute(STAFF_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public StaffDto get(@PathVariable UUID id) {
        return STAFF_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<StaffDto> list(SearchStaffDto dto, Sort sort) {
        SearchStaffArgument argument = STAFF_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(STAFF_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<StaffDto> page(SearchStaffDto dto, Pageable pageable) {
        SearchStaffArgument argument = STAFF_MAPPER.toSearchArgument(dto);

        return CollectionDto.of(service.page(argument, pageable)
                                       .map(STAFF_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
