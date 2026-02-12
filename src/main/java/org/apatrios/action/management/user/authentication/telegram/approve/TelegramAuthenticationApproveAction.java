package org.apatrios.action.management.user.authentication.telegram.approve;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.service.management.user.UserService;
import org.apatrios.util.AuthUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TelegramAuthenticationApproveAction implements Action<TelegramAuthenticationApproveActionArgument, OAuth2AccessToken> {

    AuthenticationCodeService authenticationCode;
    AuthenticationService authenticationService;
    UserService userService;

    @Override
    @Transactional
    public OAuth2AccessToken execute(@NonNull TelegramAuthenticationApproveActionArgument argument) {
        String converted = AuthUtils.convertUsername(argument.getPhoneNumber());
        authenticationCode.verifyCode(converted, argument.getCode());
        return userService.getByPhoneNumber(converted)
                          .map(user -> authenticationService.login(converted, "N/A"))
                          .orElse(null);
    }
}
