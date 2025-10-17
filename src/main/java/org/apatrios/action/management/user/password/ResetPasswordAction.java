package org.apatrios.action.management.user.password;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.VoidAction;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.notification.SendNotificationService;
import org.apatrios.util.AuthUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ResetPasswordAction implements VoidAction<String> {

    UserService userService;
    SendNotificationService notificationService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void execute(@NonNull String username) {
        String code = userService.createResetCode(username);
        if (AuthUtils.isLoginByPhone(username)) throw new EntityNotFoundException("Not supported");

        notificationService.sendPasswordResetCode(username, code);
    }
}
