package org.apatrios.api.management.user.internal;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.update.argument.UpdateUserActionArgument;
import org.apatrios.api.management.user.internal.dto.SearchUserInternalDto;
import org.apatrios.api.management.user.internal.dto.UpdatePasswordInternalDto;
import org.apatrios.api.management.user.internal.dto.UpdateUserInternalDto;
import org.apatrios.api.management.user.internal.dto.UserInternalDto;
import org.apatrios.api.management.user.internal.mapper.UserInternalMapper;
import org.apatrios.model.management.User;
import org.apatrios.service.management.user.UserService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserInternalController {

    UserService service;
    UserInternalMapper mapper;
    Action<UpdateUserActionArgument, User> updateUserInternalAction;

    @Operation(summary = "Обновление учетной записи у пользователя. Доступно с ролью ADMIN")
    @PostMapping("update")
    public UserInternalDto update(@Valid @RequestBody UpdateUserInternalDto dto) {
        return mapper.toDto(updateUserInternalAction.execute(mapper.toUpdateArgument(dto)));
    }

    @Operation(summary = "Изменение пароля у пользователя")
    @PostMapping("{id}/update-password")
    public void updatePassword(@PathVariable UUID id, @Valid @RequestBody UpdatePasswordInternalDto dto) {
        service.updatePassword(id, dto.getPassword());
    }

    @Operation(summary = "Разблокировать пользователя. Доступно с ролью ADMIN")
    @PostMapping("{id}/enable")
    public void enable(@PathVariable UUID id) {
        service.enable(id);
    }

    @Operation(summary = "Заблокировать пользователя. Доступно с ролью ADMIN")
    @PostMapping("{id}/disable")
    public void disable(@PathVariable UUID id) {
        service.delete(id);
    }

    @Operation(summary = "Получение данных пользователя. Доступно с ролью ADMIN")
    @GetMapping("{id}")
    public UserInternalDto get(@PathVariable UUID id) {
        return mapper.toDto(service.getExisting(id));
    }

    @Operation(summary = "Список пользователей. Доступно с ролью ADMIN")
    @GetMapping("list")
    public List<UserInternalDto> list(SearchUserInternalDto dto, Sort sort) {
        return service.list(mapper.toSearchArgument(dto), sort)
                      .stream()
                      .map(mapper::toDto)
                      .toList();
    }

    @Operation(summary = "Постраничный вывод пользователей. Доступно с ролью ADMIN")
    @GetMapping("page")
    public CollectionDto<UserInternalDto> page(SearchUserInternalDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(mapper.toSearchArgument(dto), pageable)
                                       .map(mapper::toDto));
    }
}
