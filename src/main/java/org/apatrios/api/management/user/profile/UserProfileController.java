package org.apatrios.api.management.user.profile;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.user.profile.avatar.ChangeAvatarAction;
import org.apatrios.action.management.user.profile.email.approve.argument.ChangeEmailApproveActionArgument;
import org.apatrios.api.management.user.profile.dto.ChangeEmailApproveDto;
import org.apatrios.api.management.user.profile.dto.ChangeEmailRequestDto;
import org.apatrios.api.management.user.profile.dto.UserProfileDto;
import org.apatrios.api.management.user.profile.mapper.ProfileMapper;
import org.apatrios.model.management.User;
import org.apatrios.service.management.user.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
@Validated
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserProfileController {

    UserService service;
    ProfileMapper mapper;
    VoidAction<String> changeEmailRequestAction;
    Action<ChangeEmailApproveActionArgument, User> changeEmailApproveAction;
    ChangeAvatarAction changeAvatarAction;

    @Operation(summary = "Получение данных пользователя")
    @GetMapping("{id}")
    public UserProfileDto get(@PathVariable UUID id) {
        return mapper.toDto(service.getExisting(id));
    }

    @Operation(summary = "Отправка кода на почту")
    @PostMapping("/change_email/request")
    public void changeEmailRequest(@Valid @RequestBody ChangeEmailRequestDto dto) {
        changeEmailRequestAction.execute(dto.email());
    }

    @Operation(summary = "Проверка кода и смена почты")
    @PostMapping("/change_email/approve")
    public UserProfileDto changeEmailApprove(@Valid @RequestBody ChangeEmailApproveDto dto) {
        return mapper.toDto(changeEmailApproveAction.execute(mapper.toChangeEmailApproveArgument(dto)));
    }

    @Operation(summary = "Поменять аватар по айди юзера")
    @PostMapping("{id}/change_avatar")
    public UserProfileDto changeAvatar(@PathVariable UUID id, @RequestParam("file") MultipartFile file) {
        return mapper.toDto(changeAvatarAction.execute(id, file));
    }
}
