package org.apatrios.config.properties;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "oauth2.client")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OAuth2ClientProperties {

    /** идентификатор клиента */
    String clientId;

    /** пароль клиента */
    String clientSecret;

    /** область доступа */
    String scope;
}
