package org.apatrios.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@Order(3)
@EnableResourceServer
public class OAuth2SecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .anonymous().and()
            .authorizeRequests()
            .antMatchers("/auth/**", "/profile/**", "/webhook/**").permitAll()
            .antMatchers("/swagger-ui/**", "/v3/**").permitAll()
            .anyRequest().authenticated();
    }
}