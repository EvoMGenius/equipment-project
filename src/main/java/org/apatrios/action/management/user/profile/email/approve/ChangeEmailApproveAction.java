package org.apatrios.action.management.user.profile.email.approve;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.profile.email.approve.argument.ChangeEmailApproveActionArgument;
import org.apatrios.model.management.User;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChangeEmailApproveAction implements Action<ChangeEmailApproveActionArgument, User> {

    AuthenticationCodeService authenticationCodeService;
    UserService userService;

    @Override
    @Transactional
    public User execute(@NonNull ChangeEmailApproveActionArgument argument) {
        authenticationCodeService.verifyCode(argument.getEmail(), argument.getCode());
        return userService.update(argument.getId(), UpdateUserArgument.builder()
                                                                      .email(argument.getEmail())
                                                                      .isEmailVerified(true)
                                                                      .build());
    }
}
