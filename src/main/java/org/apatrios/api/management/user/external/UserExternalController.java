package org.apatrios.api.management.user.external;

import lombok.RequiredArgsConstructor;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.user.authentication.call.approve.argument.CallAuthenticationApproveActionArgument;
import org.apatrios.action.management.user.authentication.create.argument.CreateUserActionArgument;
import org.apatrios.action.management.user.authentication.telegram.approve.argument.TelegramAuthenticationApproveActionArgument;
import org.apatrios.api.management.user.external.dto.*;
import org.apatrios.api.management.user.external.mapper.UserExternalMapper;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class UserExternalController {

    private final VoidAction<String> telegramAuthenticationRequestAction;
    private final Action<TelegramAuthenticationApproveActionArgument, OAuth2AccessToken> telegramAuthenticationApproveAction;
    private final VoidAction<String> callAuthenticationRequestAction;
    private final Action<CallAuthenticationApproveActionArgument, OAuth2AccessToken> callAuthenticationApproveAction;
    private final Action<CreateUserActionArgument, OAuth2AccessToken> createUserAction;
    private final UserExternalMapper userMapper;
    private final MinioFileService fileService;

    @Value("${legal.documents.offer.path:legal/offer.pdf}")
    private String offerPath;
    @Value("${legal.documents.opd.path:legal/opd.pdf}")
    private String opdPath;

    @PostMapping("/auth_by_tg/request")
    public void authenticationByTelegramRequest(@RequestBody TelegramAuthenticationRequestDto dto) {
        telegramAuthenticationRequestAction.execute(dto.getLogin());
    }

    @PostMapping("/auth_by_tg/approve")
    public OAuth2AccessToken authenticationByTelegramApprove(@RequestBody TelegramAuthenticationApproveDto dto) {
        return telegramAuthenticationApproveAction.execute(userMapper.toTelegramApproveArgument(dto));
    }

    @PostMapping("/auth_by_call/request")
    public void authenticationByCallRequest(@RequestBody CallAuthenticationRequestDto dto) {
        callAuthenticationRequestAction.execute(dto.getLogin());
    }

    @PostMapping("/auth_by_call/approve")
    public OAuth2AccessToken authenticationByCallApprove(@RequestBody CallAuthenticationApproveDto dto) {
        return callAuthenticationApproveAction.execute(userMapper.toCallApproveArgument(dto));
    }

    @PostMapping("/registration")
    public OAuth2AccessToken create(@RequestBody CreateUserDto dto) {
        return createUserAction.execute(userMapper.toCreateArgument(dto));
    }

    @GetMapping("offer")
    public ResponseEntity<Void> getOffer() {
        String url = fileService.getFullUrl(offerPath);
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }

    @GetMapping("opd")
    public ResponseEntity<Void> getOpd() {
        String url = fileService.getFullUrl(opdPath);
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(url))
                             .build();
    }
}
