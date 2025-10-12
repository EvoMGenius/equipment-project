package org.apatrios.action.authentication.create;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.service.notification.SendNotificationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateAuthenticationCodeAction {

    AuthenticationCodeService authenticationCodeService;
    SendNotificationService notificationService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void execute() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID code = authenticationCodeService.createVerificationCode(name);
        notificationService.sendAuthenticationCode(name, code);
    }
}
