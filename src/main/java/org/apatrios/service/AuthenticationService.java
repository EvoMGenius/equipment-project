package org.apatrios.service;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.User;
import org.apatrios.service.details.ElBikesUserDetails;
import org.apatrios.service.management.user.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * Сервис аутентификации, управляющий жизненным циклом OAuth2 токенов.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationService {

    AuthorizationServerTokenServices tokenServices;
    ConsumerTokenServices consumerTokenServices;
    UserService userService;

    /**
     * Выполняет процедуру входа: проверяет существование пользователя и генерирует OAuth2 Access Token.
     * Данные клиента (client_id, scope) извлекаются напрямую из текущего HTTP-запроса.
     *
     * @param username Имя пользователя (телефон/логин).
     * @param password Пароль или временный секрет.
     * @return Объект токена доступа.
     * @throws EntityNotFoundException если пользователь не найден.
     */
    public OAuth2AccessToken login(@NonNull String username, @NonNull String password) {
        HttpServletRequest request = getHttpServletRequest();
        String clientId = getRequestValue(request, "client_id");
        String scope = getRequestValue(request, "scope");
        String clientSecret = getRequestValue(request, "client_secret");

        User user = userService.getByPhoneNumber(username)
                               .orElseThrow(() -> new EntityNotFoundException("User.notFound"));;

        return createAccessToken(ImmutableMap.<String, String>builder()
                                             .put("client_id", clientId)
                                             .put("client_secret", clientSecret)
                                             .put("username", username)
                                             .put("password", password)
                                             .put("grant_type", "password")
                                             .put("scope", scope)
                                             .build(), user);
    }

    /**
     * Внутренний метод для ручной сборки объектов Spring Security и генерации токена.
     */
    private OAuth2AccessToken createAccessToken(Map<String, String> params, User user) {
        String clientId = params.get("client_id");
        String username = params.get("username");
        String password = params.get("password");

        OAuth2Request oauth2Request = new OAuth2Request(params,
                                                        clientId,
                                                        Collections.emptySet(),
                                                        true,
                                                        ImmutableSet.of(params.get("scope")),
                                                        null,
                                                        null,
                                                        null,
                                                        null);

        ElBikesUserDetails userDetails = ElBikesUserDetails.builder()
                                                           .id(user.getId())
                                                           .username(username)
                                                           .password(user.getPassword())
                                                           .build();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
                                                                                            password,
                                                                                            Collections.emptySet());

        return tokenServices.createAccessToken(new OAuth2Authentication(oauth2Request, token));
    }

    /**
     * Завершает сессию пользователя: отзывает текущий токен и очищает SecurityContext.
     */
    public void logout() {
        removeToken();
        SecurityContextHolder.clearContext();
    }

    /**
     * Извлекает текущий токен из контекста безопасности и аннулирует его в хранилище.
     */
    private void removeToken() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) return;

        if (!(authentication.getDetails() instanceof OAuth2AuthenticationDetails)) return;

        String tokenValue = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        consumerTokenServices.revokeToken(tokenValue);
    }

    /**
     * Вспомогательный метод для получения текущего HttpServletRequest через контекст Spring.
     */
    private HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /**
     * Ищет значение параметра сначала в заголовках, затем в параметрах запроса.
     */
    private String getRequestValue(HttpServletRequest request, String name) {
        String headerValue = request.getHeader(name);

        if (headerValue != null) return headerValue;

        return request.getParameter(name);
    }
}
