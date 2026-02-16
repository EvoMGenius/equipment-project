package org.apatrios.action.management.user.authentication.call.request;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.VoidAction;
import org.apatrios.feign.call.RedSmsClient;
import org.apatrios.feign.call.dto.RedSmsRequestDto;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.apatrios.util.AuthUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CallAuthenticationRequestAction implements VoidAction<String> {

    RedSmsClient redSmsClient;
    AuthenticationCodeService authenticationCodeService;

    @Override
    public void execute(@NonNull String phoneNumber) {
        String converted = AuthUtils.convertUsername(phoneNumber);
        String code = authenticationCodeService.createCode(converted);
        redSmsClient.sendFlashCall(RedSmsRequestDto.builder()
                                                   .route("fcall")
                                                   .to(phoneNumber)
                                                   .text(code)
                                                   .build());
    }
}
