package org.apatrios.feign.call.interceptor;

import feign.RequestInterceptor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class RedSmsInterceptor {

    @Bean
    public RequestInterceptor redSmsRequestInterceptor(@Value("${redsms.login}") String login,
                                                       @Value("${redsms.api-key}") String apiKey) {
        return template -> {
            String ts = String.valueOf(System.currentTimeMillis() / 1000);
            String secret = DigestUtils.md5Hex(ts + apiKey);
            template.header("login", login);
            template.header("ts", ts);
            template.header("secret", secret);
        };
    }
}
