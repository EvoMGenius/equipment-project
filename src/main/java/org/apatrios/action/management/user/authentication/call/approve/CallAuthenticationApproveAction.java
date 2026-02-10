package org.apatrios.action.management.user.authentication.call.approve;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
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
public class CallAuthenticationApproveAction implements Action<CallAuthenticationApproveActionArgument, OAuth2AccessToken> {

    AuthenticationCodeService authenticationCode;
    AuthenticationService authenticationService;
    UserService userService;

    @Override
    @Transactional
    public OAuth2AccessToken execute(@NonNull CallAuthenticationApproveActionArgument argument) {
        String converted = AuthUtils.convertToPhone(argument.getLogin());
        authenticationCode.verifyCode(converted, argument.getCode());
        return userService.getByLogin(converted)
                          .map(user -> authenticationService.login(user.getLogin(), "N/A"))
                          .orElse(null);
    }
}
