package org.apatrios.action.authentication.create;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.VoidAction;
import org.apatrios.action.authentication.create.argument.CreateAuthenticationCodeActionArgument;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.User;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.notification.SendNotificationService;
import org.apatrios.util.AuthUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateAuthenticationCodeAction implements VoidAction<CreateAuthenticationCodeActionArgument> {

    AuthenticationCodeService authenticationCodeService;
    UserService userService;
    PasswordEncoder encoder;
    SendNotificationService notificationService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void execute(@NonNull CreateAuthenticationCodeActionArgument argument) {
        String username = AuthUtils.convertUsername(argument.getUsername());
        if (AuthUtils.isLoginByPhone(username)) throw new EntityNotFoundException("Not supported");

        User user = userService.getByUsername(username);
        if (!encoder.matches(argument.getPassword(), user.getPassword())) throw new EntityNotFoundException("User.Bad.Credentials");

        UUID code = authenticationCodeService.createVerificationCode(username);
        notificationService.sendAuthenticationCode(username, code);
    }
}
