package org.apatrios.api.management.user.external;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.authentication.AuthenticationUserActionArgument;
import org.apatrios.action.management.user.create.CreateUserActionArgument;
import org.apatrios.action.management.user.password.ResetPasswordAction;
import org.apatrios.action.management.user.password.argument.UpdatePasswordActionArgument;
import org.apatrios.api.management.user.external.dto.AuthenticationUserExternalDto;
import org.apatrios.api.management.user.external.dto.CreateUserExternalDto;
import org.apatrios.api.management.user.external.dto.ResetPasswordByCodeExternalDto;
import org.apatrios.api.management.user.external.dto.UpdatePasswordByCodeExternalDto;
import org.apatrios.api.management.user.external.mapper.UserExternalMapper;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("external/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserExternalController {

    ResetPasswordAction resetPasswordAction;
    Action<UpdatePasswordActionArgument, OAuth2AccessToken> updatePasswordAction;
    UserExternalMapper userMapper;
    Action<CreateUserActionArgument, OAuth2AccessToken> createUserAction;
    Action<AuthenticationUserActionArgument, OAuth2AccessToken> authenticationUserAction;

    @Operation(summary = "Создание кода для изменения пароля")
    @PostMapping("reset-password-by-code")
    public void resetPasswordByCode(@Valid @RequestBody ResetPasswordByCodeExternalDto dto) {
        resetPasswordAction.execute(dto.getUsername());
    }

    @Operation(summary = "Изменение пароля по коду")
    @PostMapping("update-password-by-code")
    public OAuth2AccessToken updatePasswordByCode(@Valid @RequestBody UpdatePasswordByCodeExternalDto dto) {
        UpdatePasswordActionArgument argument = userMapper.toUpdatePasswordArgument(dto);
        return updatePasswordAction.execute(argument);
    }

    @Operation(summary = "Создание учетной записи пользователя с последующей выдачей токенов доступа")
    @PostMapping("register")
    public OAuth2AccessToken registration(@Valid @RequestBody CreateUserExternalDto dto) {
        return createUserAction.execute(userMapper.toCreateArgument(dto));
    }

    @Operation(summary = "Повторный вход в систему")
    @PostMapping("login")
    public OAuth2AccessToken login(@Valid @RequestBody AuthenticationUserExternalDto dto) {
        return authenticationUserAction.execute(userMapper.toAuthenticationArgument(dto));
    }
}
