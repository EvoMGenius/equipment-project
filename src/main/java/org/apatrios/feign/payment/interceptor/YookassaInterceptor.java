package org.apatrios.feign.payment.interceptor;

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
        return template -> {
            if (template.feignTarget().name().equals("payment-client")) {
                manager.getCurrent().configure(template);
            }
        };
    }
}
