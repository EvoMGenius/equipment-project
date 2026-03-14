package org.apatrios.feign.payment.interceptor;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Base64;

public class YookassaInterceptor {

    @Bean
    public RequestInterceptor yookassaRequestInterceptor(
            @Value("${yookassa.auth.type}") String authType,
            @Value("${yookassa.token}") String token,
            @Value("${yookassa.shop-id}") String shopId,
            @Value("${yookassa.secret-key}") String secretKey) {

        String authHeader = switch (AuthType.valueOf(authType.toUpperCase())) {
            case BASIC -> "Basic " + Base64.getEncoder().encodeToString((shopId + ":" + secretKey).getBytes());
            case TOKEN -> "Bearer " + token;
        };

        return template -> template.header("Authorization", authHeader);
    }
}
