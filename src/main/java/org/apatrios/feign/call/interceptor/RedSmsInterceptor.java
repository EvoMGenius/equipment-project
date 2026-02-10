package org.apatrios.feign.call.interceptor;

import feign.RequestInterceptor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedSmsInterceptor {

    @Value("${redsms.login}")
    private String login;

    @Value("${redsms.api-key}")
    private String apiKey;

    @Bean
    public RequestInterceptor redSmsRequestInterceptor() {
        return template -> {
            String ts = String.valueOf(System.currentTimeMillis() / 1000);
            String secret = DigestUtils.md5Hex(ts + apiKey);

            template.header("login", login);
            template.header("ts", ts);
            template.header("secret", secret);
        };
    }
}
