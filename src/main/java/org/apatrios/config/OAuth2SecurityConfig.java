package org.apatrios.config;

import lombok.RequiredArgsConstructor;
import org.apatrios.config.properties.CorsAllowedOriginsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@Order(3)
@EnableResourceServer
@RequiredArgsConstructor
@EnableConfigurationProperties(CorsAllowedOriginsProperties.class)
public class OAuth2SecurityConfig extends ResourceServerConfigurerAdapter {

    private final CorsAllowedOriginsProperties corsAllowedOriginsProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and()
            .csrf().disable()
            .anonymous().and()
            .authorizeRequests()
            .antMatchers("/auth/**", "/webhook/**").permitAll()
            .antMatchers("/swagger-ui/**", "/v3/**").permitAll()
            .anyRequest().authenticated();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(corsAllowedOriginsProperties.getAllowedOrigins());
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        configuration.setAllowedHeaders(Arrays.asList("Authorization",
                                                      "Content-Type",
                                                      "client_id",
                                                      "client_secret",
                                                      "scope"));

        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}