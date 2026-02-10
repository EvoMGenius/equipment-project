package org.apatrios.service.authentication;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.apatrios.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationCodeService {

    Cache<String, String> codes = CacheBuilder.newBuilder()
                                              .expireAfterWrite(30, TimeUnit.MINUTES)
                                              .maximumSize(10000)
                                              .build();
    Cache<String, Bucket> limits = CacheBuilder.newBuilder()
                                               .expireAfterAccess(1, TimeUnit.HOURS)
                                               .maximumSize(10000)
                                               .build();

    public String createCode(String target) {
        if (!getBucket("SEND:" + target, 1, Duration.ofMinutes(1)).tryConsume(1))
            throw new EntityNotFoundException("Limit.exceeded.resend");

        String code = RandomStringUtils.randomNumeric(4);
        codes.put(target, code);
        return code;
    }

    public void verifyCode(String target, String inputCode) {
        Bucket verifyBucket = getBucket("VERIFY:" + target, 3, Duration.ofMinutes(30));
        if (!verifyBucket.tryConsume(1)) throw new EntityNotFoundException("Limit.exceeded.blocked");

        String validCode = codes.getIfPresent(target);

        if (inputCode.equals(validCode)) {
            codes.invalidate(target);
            limits.invalidate("VERIFY:" + target);
            return;
        }
        throw new EntityNotFoundException("Code.invalid.remaining.attempts");
    }

    private Bucket getBucket(String key, int capacity, Duration duration) {
        try {
            return limits.get(key, () -> Bucket.builder()
                                               .addLimit(Bandwidth.simple(capacity, duration))
                                               .build());
        } catch (Exception e) {
            throw new EntityNotFoundException("Error.creating.bucket");
        }
    }
}
