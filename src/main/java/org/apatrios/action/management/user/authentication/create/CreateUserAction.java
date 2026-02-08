package org.apatrios.action.management.user.authentication.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.authentication.create.argument.CreateUserActionArgument;
import org.apatrios.model.management.UserProfile;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
                                             .login(argument.getLogin())
                                             .password("N/A")
                                             .userProfile(UserProfile.builder()
                                                                     .firstName(argument.getUserProfile().getFirstName())
                                                                     .build())
                                             .build());
        return authenticationService.login(argument.getLogin(), "N/A");
    }
}
