package org.apatrios.api.management.user.authentication;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.registration.argument.CompleteRegistrationUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.authentication.dto.*;
import org.apatrios.api.management.user.authentication.mapper.AuthenticationMapper;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.service.AuthenticationService;
import org.apatrios.util.FileUrlSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
@Validated
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationController {

    VoidAction<String> telegramAuthenticationRequestAction;
    Action<TelegramAuthenticationApproveActionArgument, Optional<OAuth2AccessToken>> telegramAuthenticationApproveAction;
    VoidAction<String> callAuthenticationRequestAction;
    Action<CallAuthenticationApproveActionArgument, Optional<OAuth2AccessToken>> callAuthenticationApproveAction;
    Action<CompleteRegistrationUserActionArgument, OAuth2AccessToken> completeRegistrationUserAction;
    AuthenticationMapper userMapper;
    FileUrlSerializer fileUrlSerializer;
    DocumentProperties documentProperties;
    AuthenticationService authenticationService;

    @PostMapping("/auth_by_tg/request")
    public void authenticationByTelegramRequest(@Valid @RequestBody TelegramAuthenticationRequestDto dto) {
        telegramAuthenticationRequestAction.execute(dto.phoneNumber());
    }

    @PostMapping("/auth_by_tg/approve")
    public ResponseEntity<OAuth2AccessToken> authenticationByTelegramApprove(@Valid @RequestBody TelegramAuthenticationApproveDto dto) {
        return telegramAuthenticationApproveAction.execute(userMapper.toTelegramApproveArgument(dto))
                                                  .map(ResponseEntity::ok)
                                                  .orElse(ResponseEntity.ok().build());
    }

    @PostMapping("/auth_by_call/request")
    public void authenticationByCallRequest(@Valid @RequestBody CallAuthenticationRequestDto dto) {
        callAuthenticationRequestAction.execute(dto.phoneNumber());
    }

    @PostMapping("/auth_by_call/approve")
    public ResponseEntity<OAuth2AccessToken> authenticationByCallApprove(@Valid @RequestBody CallAuthenticationApproveDto dto) {
        return callAuthenticationApproveAction.execute(userMapper.toCallApproveArgument(dto))
                                              .map(ResponseEntity::ok)
                                              .orElse(ResponseEntity.ok().build());
    }

    @PostMapping("/registration")
    public OAuth2AccessToken registration(@Valid @RequestBody CompleteRegistrationUserDto dto) {
        return completeRegistrationUserAction.execute(userMapper.toCreateArgument(dto));
    }

    @GetMapping("/logout")
    public void logout() {
        authenticationService.logout();
    }

    @GetMapping("offer")
    public ResponseEntity<Void> getOffer() {
        String url = fileUrlSerializer.getFullUrl(documentProperties.getOfferPath());
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }

    @GetMapping("opd")
    public ResponseEntity<Void> getOpd() {
        String url = fileUrlSerializer.getFullUrl(documentProperties.getOpdPath());
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }
}
