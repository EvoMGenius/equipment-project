package org.apatrios.config;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RetryFeignConfig {

    @Primary
    @Bean
    public Retryer retryer(
            @Value("${feign.client.config.default.retry.connectTimeout:1000}") long maxPeriod,
            @Value("${feign.client.config.default.retry.period:100}") long period,
            @Value("${feign.client.config.default.retry.maxAttempts:5}") int maxAttempts
                          ) {
        return new Retryer.Default(period, maxPeriod, maxAttempts);
    }

}