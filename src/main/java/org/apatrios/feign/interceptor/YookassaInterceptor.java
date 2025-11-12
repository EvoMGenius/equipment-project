package org.apatrios.feign.interceptor;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.apatrios.config.yookassa.AuthenticationConfigurerManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class YookassaInterceptor {

    private final AuthenticationConfigurerManager manager;

    @Bean
    public RequestInterceptor yooKassaAuthInterceptor() {
        return template -> manager.getCurrent().configure(template);
    }
}
