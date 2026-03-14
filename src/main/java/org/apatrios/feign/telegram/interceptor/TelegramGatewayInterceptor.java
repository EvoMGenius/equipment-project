package org.apatrios.feign.telegram.interceptor;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class TelegramGatewayInterceptor {
    @Bean
    public RequestInterceptor telegramGatewayRequestInterceptor(@Value("${telegram.gateway.token}") String token) {
        return template -> template.header("Authorization", "Bearer " + token);
    }
}
