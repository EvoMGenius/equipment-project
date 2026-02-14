package org.apatrios.api.management.user.authentication;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.create.argument.CreateUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.authentication.dto.*;
import org.apatrios.api.management.user.authentication.mapper.AuthenticationMapper;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.service.AuthenticationService;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationController {

    VoidAction<String> telegramAuthenticationRequestAction;
    Action<TelegramAuthenticationApproveActionArgument, OAuth2AccessToken> telegramAuthenticationApproveAction;
    VoidAction<String> callAuthenticationRequestAction;
    Action<CallAuthenticationApproveActionArgument, OAuth2AccessToken> callAuthenticationApproveAction;
    Action<CreateUserActionArgument, OAuth2AccessToken> createUserAction;
    AuthenticationMapper userMapper;
    MinioFileService fileService;
    DocumentProperties documentProperties;
    AuthenticationService authenticationService;

    @PostMapping("/auth_by_tg/request")
    public void authenticationByTelegramRequest(@RequestBody TelegramAuthenticationRequestDto dto) {
        telegramAuthenticationRequestAction.execute(dto.getPhoneNumber());
    }

    @PostMapping("/auth_by_tg/approve")
    public OAuth2AccessToken authenticationByTelegramApprove(@RequestBody TelegramAuthenticationApproveDto dto) {
        return telegramAuthenticationApproveAction.execute(userMapper.toTelegramApproveArgument(dto));
    }

    @PostMapping("/auth_by_call/request")
    public void authenticationByCallRequest(@RequestBody CallAuthenticationRequestDto dto) {
        callAuthenticationRequestAction.execute(dto.getPhoneNumber());
    }

    @PostMapping("/auth_by_call/approve")
    public OAuth2AccessToken authenticationByCallApprove(@RequestBody CallAuthenticationApproveDto dto) {
        return callAuthenticationApproveAction.execute(userMapper.toCallApproveArgument(dto));
    }

    @PostMapping("/registration")
    public OAuth2AccessToken create(@RequestBody CreateUserDto dto) {
        return createUserAction.execute(userMapper.toCreateArgument(dto));
    }

    @GetMapping("/logout")
    public void logout() {
        authenticationService.logout();
    }

    @GetMapping("offer")
    public ResponseEntity<Void> getOffer() {
        String url = fileService.getFullUrl(documentProperties.getOfferPath());
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }

    @GetMapping("opd")
    public ResponseEntity<Void> getOpd() {
        String url = fileService.getFullUrl(documentProperties.getOpdPath());
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }
}
