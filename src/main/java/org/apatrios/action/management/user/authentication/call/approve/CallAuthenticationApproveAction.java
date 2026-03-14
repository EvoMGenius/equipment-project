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
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.apatrios.util.AuthUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CallAuthenticationApproveAction implements Action<CallAuthenticationApproveActionArgument, Optional<OAuth2AccessToken>> {

    AuthenticationCodeService authenticationCode;
    AuthenticationService authenticationService;
    UserService userService;

    @Override
    @Transactional
    public Optional<OAuth2AccessToken> execute(@NonNull CallAuthenticationApproveActionArgument argument) {
        String converted = AuthUtils.convertUsername(argument.phoneNumber());
        authenticationCode.verifyCode(converted, argument.code());

        return userService.getByPhoneNumber(converted)
                          .map(user -> authenticationService.login(converted))
                          .or(() -> {
                              userService.create(CreateUserArgument.builder()
                                                                   .phoneNumber(converted)
                                                                   .authorities(Set.of("USER"))
                                                                   .build());
                              return Optional.empty();
                          });
    }
}
