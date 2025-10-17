package org.apatrios.action.management.user.password;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.password.argument.UpdatePasswordActionArgument;
import org.apatrios.model.management.User;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.management.user.UserService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdatePasswordAction implements Action<UpdatePasswordActionArgument, OAuth2AccessToken> {

    UserService userService;
    AuthenticationService authenticationService;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public OAuth2AccessToken execute(@NonNull UpdatePasswordActionArgument argument) {
        User user = userService.updatePasswordByCode(argument.getPassword(), argument.getCode());

        return authenticationService.login(user.getUsername(), user.getPassword());
    }
}