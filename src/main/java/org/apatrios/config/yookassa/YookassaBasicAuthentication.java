package org.apatrios.config.yookassa;

import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class YookassaBasicAuthentication implements AuthenticationConfigurer {

    private final String encodedCredentials;

    public YookassaBasicAuthentication(@Value("${yookassa.shop-id}") String shopId, @Value("${yookassa.secret-key}") String secretKey) {
        this.encodedCredentials = Base64.getEncoder().encodeToString((shopId + ":" + secretKey).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void configure(RequestTemplate template) {
        template.header("Authorization", "Basic " + encodedCredentials);
    }

    @Override
    public String getType() {
        return "basic";
    }
}