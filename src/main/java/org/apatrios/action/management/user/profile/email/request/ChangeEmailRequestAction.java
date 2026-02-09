package org.apatrios.action.management.user.profile.email.request;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.VoidAction;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.service.notification.SendNotificationService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChangeEmailRequestAction implements VoidAction<String> {

    SendNotificationService sendNotificationService;
    AuthenticationCodeService authenticationCodeService;

    @Override
    public void execute(@NonNull String email) {
        String code = authenticationCodeService.createCode(email);
        sendNotificationService.sendAuthenticationCode(email, code);
    }
}
