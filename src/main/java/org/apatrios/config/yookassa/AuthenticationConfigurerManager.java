package org.apatrios.config.yookassa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AuthenticationConfigurerManager {

    private final Map<String, AuthenticationConfigurer> strategies;
    private final String activeType;

    public AuthenticationConfigurerManager(List<AuthenticationConfigurer> configurers, @Value("${yookassa.auth.type:basic}") String activeType) {
        this.activeType = activeType.toLowerCase();
        this.strategies = configurers.stream().collect(Collectors.toMap(c -> c.getType().toLowerCase(), Function.identity()));
    }

    public AuthenticationConfigurer getCurrent() {
        return strategies.get(activeType);
    }
}