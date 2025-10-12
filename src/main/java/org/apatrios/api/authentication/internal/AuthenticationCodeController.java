package org.apatrios.api.authentication.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.authentication.create.CreateAuthenticationCodeAction;
import org.apatrios.api.authentication.internal.dto.CompleteAuthenticationCodeDto;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("code")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationCodeController {

    CreateAuthenticationCodeAction createAuthenticationCodeAction;
    AuthenticationCodeService authenticationCodeService;

    @GetMapping("init")
    public void init() {
        createAuthenticationCodeAction.execute();
    }

    @PostMapping("complete")
    public OAuth2AccessToken complete(@RequestBody CompleteAuthenticationCodeDto dto) {
        return authenticationCodeService.login(dto.getCode());
    }
}
