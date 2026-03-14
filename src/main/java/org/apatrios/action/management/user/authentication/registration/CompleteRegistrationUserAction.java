package org.apatrios.action.management.user.authentication.registration;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.authentication.registration.argument.CompleteRegistrationUserActionArgument;
import org.apatrios.model.management.User;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CompleteRegistrationUserAction implements Action<CompleteRegistrationUserActionArgument, OAuth2AccessToken> {

    UserService userService;
    AuthenticationService authenticationService;

    @Override
    @Transactional
    public OAuth2AccessToken execute(@NonNull CompleteRegistrationUserActionArgument argument) {
        User user = userService.update(argument.id(), UpdateUserArgument.builder()
                                                                        .userProfile(UserProfile.builder()
                                                                                                .firstName(argument.userProfile().getFirstName())
                                                                                                .build())
                                                                        .status(UserStatus.REGISTERED)
                                                                        .build());

        return authenticationService.login(user.getPhoneNumber());
    }
}
