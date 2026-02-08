package org.apatrios.feign.telegram;

import org.apatrios.feign.telegram.dto.TelegramSendRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "telegram-gateway", url = "https://gatewayapi.telegram.org")
public interface TelegramGatewayClient {

    @PostMapping("/sendVerificationMessage")
    void sendVerificationMessage(@RequestHeader("Authorization") String token, @RequestBody TelegramSendRequestDto dto);
}
