package org.apatrios.config.yookassa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "yookassa.auth")
public class YooKassaAuthProperties {

    /**
     * Тип аутентификации: basic или bearer
     */
    private String type;
}
