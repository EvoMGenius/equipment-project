package org.apatrios.config.yookassa;

import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "yookassa.token")
public class YookassaBearerTokenAuthentication implements AuthenticationConfigurer {

    private final String token;

    public YookassaBearerTokenAuthentication(@Value("${yookassa.token}") String token) {
        this.token = token;
    }

    @Override
    public void configure(RequestTemplate template) {
        template.header("Authorization", "Bearer " + token);
    }

    @Override
    public String getType() {
        return "bearer";
    }
}