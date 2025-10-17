package org.apatrios.api.authentication.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.VoidAction;
import org.apatrios.action.authentication.create.argument.CreateAuthenticationCodeActionArgument;
import org.apatrios.api.authentication.internal.dto.CompleteAuthenticationCodeDto;
import org.apatrios.api.authentication.internal.dto.CreateAuthenticationCodeDto;
import org.apatrios.api.authentication.internal.mapper.AuthenticationCodeMapper;
import org.apatrios.service.authentication.AuthenticationCodeService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("code")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationCodeController {

    VoidAction<CreateAuthenticationCodeActionArgument> createAuthenticationCodeAction;
    AuthenticationCodeMapper mapper;
    AuthenticationCodeService authenticationCodeService;

    @PostMapping("init")
    public void init(@RequestBody CreateAuthenticationCodeDto dto) {
        createAuthenticationCodeAction.execute(mapper.toCreateArgument(dto));
    }

    @PostMapping("complete")
    public OAuth2AccessToken complete(@RequestBody CompleteAuthenticationCodeDto dto) {
        return authenticationCodeService.login(dto.getCode());
    }
}
