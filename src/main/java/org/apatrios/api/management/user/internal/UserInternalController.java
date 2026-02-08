package org.apatrios.api.management.user.internal;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.user.change.avatar.ChangeAvatarAction;
import org.apatrios.action.management.user.change.email.approve.argument.ChangeEmailApproveActionArgument;
import org.apatrios.api.management.user.internal.dto.ChangeEmailApproveDto;
import org.apatrios.api.management.user.internal.dto.ChangeEmailRequestDto;
import org.apatrios.api.management.user.internal.dto.UserInternalDto;
import org.apatrios.api.management.user.internal.mapper.UserInternalMapper;
import org.apatrios.model.management.User;
import org.apatrios.service.management.user.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserInternalController {

    UserService service;
    UserInternalMapper mapper;
    VoidAction<String> changeEmailRequestAction;
    Action<ChangeEmailApproveActionArgument, User> changeEmailApproveAction;
    ChangeAvatarAction changeAvatarAction;

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

    @Operation(summary = "Отправка кода на почту")
    @PostMapping("/change_email/request")
    public void changeEmailRequest(@RequestBody ChangeEmailRequestDto dto) {
        changeEmailRequestAction.execute(dto.getEmail());
    }

    @Operation(summary = "Проверка кода и смена почты")
    @PostMapping("/change_email/approve")
    public UserInternalDto changeEmailApprove(@RequestBody ChangeEmailApproveDto dto) {
        return mapper.toDto(changeEmailApproveAction.execute(mapper.toChangeEmailApproveArgument(dto)));
    }

    @Operation(summary = "Поменять аватар по айди юзера")
    @PostMapping("change_avatar")
    public UserInternalDto changeAvatar(@RequestParam("userId") UUID userId, @RequestParam("file") MultipartFile file) {
        return mapper.toDto(changeAvatarAction.execute(userId, file));
    }
}
