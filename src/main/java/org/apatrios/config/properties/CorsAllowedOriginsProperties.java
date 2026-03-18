package org.apatrios.config.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@ConfigurationProperties(prefix = "cors")
public class CorsAllowedOriginsProperties {

    private final List<String> allowedOrigins = new ArrayList<>();
}
