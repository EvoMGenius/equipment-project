package org.apatrios.service.authentication;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.service.AuthenticationService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthenticationCodeService {

    private final Cache<UUID, String> cache = CacheBuilder.newBuilder()
                                                          .expireAfterWrite(10, TimeUnit.MINUTES)
                                                          .maximumSize(10000)
                                                          .build();
    private final AuthenticationService authenticationService;

    public UUID createVerificationCode(@NonNull String username) {
        UUID code = UUID.randomUUID();
        cache.put(code, username);
        return code;
    }

    public OAuth2AccessToken login(@NonNull UUID verificationCode) {
        String username = cache.getIfPresent(verificationCode);
        if (username == null) throw new EntityNotFoundException("Code.username.notFound");
        cache.invalidate(verificationCode);
        return authenticationService.login(username, "N/A");
    }
}
