package org.apatrios.action.management.user.authentication.telegram.request;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.action.VoidAction;
import org.apatrios.feign.telegram.TelegramGatewayClient;
import org.apatrios.feign.telegram.dto.TelegramSendRequestDto;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.util.AuthUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TelegramAuthenticationRequestAction implements VoidAction<String> {

    private final AuthenticationCodeService authenticationCode;
    private final TelegramGatewayClient telegramGatewayClient;
    @Value("${telegram.gateway.token}")
    private String token;

    @Override
    public void execute(@NonNull String argument) {
        String converted = AuthUtils.convertToPhone(argument);
        String code = authenticationCode.createCode(converted);
        telegramGatewayClient.sendVerificationMessage("Bearer " + token, TelegramSendRequestDto.builder()
                                                                                               .code(code)
                                                                                               .phoneNumber(converted)
                                                                                               .build());
    }
}
