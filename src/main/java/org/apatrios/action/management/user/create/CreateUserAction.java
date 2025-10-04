package org.apatrios.action.management.user.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateUserAction implements Action<CreateUserActionArgument, OAuth2AccessToken> {

    UserService userService;
    AuthenticationService authenticationService;

    @Override
    @Transactional
    public OAuth2AccessToken execute(@NonNull CreateUserActionArgument argument) {
        userService.create(CreateUserArgument.builder()
                                             .username(argument.getUsername())
                                             .password(argument.getPassword())
                                             .authorities(Set.of("USER"))
                                             .userProfile(argument.getUserProfile())
                                             .build());

        return authenticationService.login(argument.getUsername(), argument.getPassword());
    }
}
