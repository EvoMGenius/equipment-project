package org.apatrios.service.management.user;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.User;
import org.apatrios.model.management.QUser;
import org.apatrios.model.management.UserStatus;
import org.apatrios.repository.managment.UserRepository;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.apatrios.service.management.user.argument.SearchUserArgument;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository repository;
    QUser qUser = QUser.user;
    PasswordEncoder encoder;
    Cache<String, String> resetCodeCache = CacheBuilder.newBuilder()
                                                       .expireAfterWrite(10, TimeUnit.MINUTES)
                                                       .maximumSize(10000)
                                                       .build();

    @Transactional
    public User create(@NonNull CreateUserArgument argument) {
        return repository.save(User.builder()
                                   .username(argument.getUsername())
                                   .password(encoder.encode(argument.getPassword()))
                                   .authorities(argument.getAuthorities())
                                   .status(UserStatus.ACTIVE)
                                   .createDate(LocalDateTime.now())
                                   .updateDate(LocalDateTime.now())
                                   .lastLogin(LocalDateTime.now())
                                   .userProfile(argument.getUserProfile())
                                   .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User update(@NonNull UUID id, @NonNull UpdateUserArgument argument) {
        User existing = getExisting(id);

        existing.setUsername(argument.getUsername());
        existing.setAuthorities(argument.getAuthorities());
        existing.setStatus(argument.getStatus());
        existing.setUserProfile(argument.getUserProfile());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<User> list(@NonNull SearchUserArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<User> page(@NonNull SearchUserArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchUserArgument argument) {
        return QPredicates.builder()
                          .add(argument.getUsername(), qUser.username::containsIgnoreCase)
                          .add(argument.getLastLoginFrom(), qUser.lastLogin::goe)
                          .add(argument.getLastLoginTo(), qUser.lastLogin::loe)
                          .add(argument.getAuthorities(), auths -> qUser.authorities.any().in(auths))
                          .add(argument.getStatus(), qUser.status::eq)
                          .add(argument.getCreateDateFrom(), qUser.createDate::goe)
                          .add(argument.getCreateDateTo(), qUser.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qUser.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qUser.updateDate::loe)
                          .add(argument.isEnabled(), qUser.enabled::eq)
                          .add(argument.getFirstName(), qUser.userProfile.firstName::eq)
                          .add(argument.getLastName(), qUser.userProfile.lastName::eq)
                          .add(argument.getMiddleName(), qUser.userProfile.middleName::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public User getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("User.notFound"));
    }

    @Transactional(readOnly = true)
    public User getByUsername(@NonNull String username) {
        return repository.findByUsername(username)
                         .orElseThrow(() -> new EntityNotFoundException("User.notFound"));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User updatePasswordByCode(@NonNull String password, @NonNull String code) {
        String username = resetCodeCache.getIfPresent(code);

        if (username == null) throw new EntityNotFoundException("Code.isExpired");

        User user = getByUsername(username);
        user.setPassword(encoder.encode(password));
        resetCodeCache.invalidate(code);
        return user;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updatePassword(@NonNull UUID id, @NonNull String password) {
        User user = getExisting(id);
        user.setPassword(encoder.encode(password));
        repository.save(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public String createResetCode(@NonNull String username) {
        String code = RandomStringUtils.randomNumeric(6);
        resetCodeCache.put(code, username);
        return code;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        User existing = getExisting(id);
        existing.setEnabled(false);
        existing.setStatus(UserStatus.BLOCKED);
        repository.save(existing);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void enable(@NonNull UUID id) {
        User user = getExisting(id);
        user.setEnabled(true);
        repository.save(user);
    }
}
