package org.apatrios.service;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.User;
import org.apatrios.model.management.UserProfile;
import org.apatrios.service.details.ElBikesUserDetails;
import org.apatrios.service.management.user.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationService {

    AuthorizationServerTokenServices tokenServices;
    UserService userService;

    public OAuth2AccessToken login(@NonNull String username, @NonNull String password) {
        HttpServletRequest request = getHttpServletRequest();
        String clientId = getRequestValue(request, "client_id");
        String scope = getRequestValue(request, "scope");
        String clientSecret = getRequestValue(request, "client_secret");

        User user = userService.getByUsername(username);

        return createAccessToken(ImmutableMap.<String, String>builder()
                                             .put("client_id", clientId)
                                             .put("client_secret", clientSecret)
                                             .put("username", username)
                                             .put("password", password)
                                             .put("grant_type", "password")
                                             .put("scope", scope)
                                             .build(), user);
    }

    private OAuth2AccessToken createAccessToken(Map<String, String> params, User user) {
        String clientId = params.get("client_id");
        String username = params.get("username");
        String password = params.get("password");

        Set<SimpleGrantedAuthority> authorities = user.getAuthorities().stream()
                                                      .map(SimpleGrantedAuthority::new)
                                                      .collect(Collectors.toSet());

        OAuth2Request oauth2Request = new OAuth2Request(params,
                                                        clientId,
                                                        authorities,
                                                        true,
                                                        ImmutableSet.of(params.get("scope")),
                                                        null,
                                                        null,
                                                        null,
                                                        null);

        UserProfile profile = user.getUserProfile();
        ElBikesUserDetails userDetails = ElBikesUserDetails.builder()
                                                           .id(user.getId())
                                                           .authorities(authorities)
                                                           .username(username)
                                                           .firstName(profile.getFirstName())
                                                           .lastName(profile.getLastName())
                                                           .middleName(profile.getMiddleName())
                                                           .password(user.getPassword())
                                                           .enabled(user.isEnabled())
                                                           .build();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
                                                                                            password,
                                                                                            authorities);

        return tokenServices.createAccessToken(new OAuth2Authentication(oauth2Request, token));
    }


    private HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    private String getRequestValue(HttpServletRequest request, String name) {
        String headerValue = request.getHeader(name);

        if (headerValue != null) return headerValue;

        return request.getParameter(name);
    }
}
