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

/**
 * Сервис для генерации и проверки одноразовых кодов авторизации.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationCodeService {

    /** Кэш для хранения активных кодов.
     * Ключ — телефон/email, значение — 4-значный код.
     * Срок жизни — 30 мин. */
    Cache<String, String> codes = CacheBuilder.newBuilder()
                                              .expireAfterWrite(30, TimeUnit.MINUTES)
                                              .maximumSize(10000)
                                              .build();
    /** Кэш для хранения лимитов для каждого пользователя.
     *  Предотвращает спам кодами и перебор. */
    Cache<String, Bucket> limits = CacheBuilder.newBuilder()
                                               .expireAfterAccess(1, TimeUnit.HOURS)
                                               .maximumSize(10000)
                                               .build();

    /**
     * Генерирует новый код для цели.
     * Введен лимит: не более 1 кода в минуту для одного номера.
     * * @param target номер телефона или email.
     * @return 4-значный цифровой код.
     * @throws EntityNotFoundException если превышен лимит на повторную отправку.
     */
    public String createCode(String target) {
        if (!getBucket("SEND:" + target, 1, Duration.ofMinutes(1)).tryConsume(1))
            throw new EntityNotFoundException("Limit.exceeded.resend");

        String code = RandomStringUtils.randomNumeric(4);
        codes.put(target, code);
        return code;
    }

    /**
     * Проверяет введенный пользователем код.
     * Введен лимит на подбор: не более 3 попыток в течение 30 минут.
     * * @param target номер телефона или email.
     * @param inputCode Код, введенный пользователем.
     * @throws EntityNotFoundException если код неверный или превышено количество попыток.
     */
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

    /**
     * Создает или возвращает существующий Bucket для конкретного ключа.
     * * @param key Уникальный ключ (действие + цель).
     * @param capacity Максимальное количество разрешенных действий.
     * @param duration Период времени, за который восстанавливаются действия.
     * @return Объект Bucket для контроля лимитов.
     */
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
