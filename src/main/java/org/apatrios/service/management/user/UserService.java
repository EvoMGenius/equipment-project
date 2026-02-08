package org.apatrios.service.management.user;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.User;
import org.apatrios.model.management.UserStatus;
import org.apatrios.repository.managment.UserRepository;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository repository;
    PasswordEncoder encoder;

    @Transactional
    public User create(@NonNull CreateUserArgument argument) {
        return repository.save(User.builder()
                                   .username(argument.getUsername())
                                   .password(encoder.encode(argument.getPassword()))
                                   .roles(argument.getUserRoles())
                                   .status(UserStatus.ACTIVE)
                                   .createDate(LocalDateTime.now())
                                   .updateDate(LocalDateTime.now())
                                   .lastLogin(LocalDateTime.now())
                                   .userProfile(argument.getUserProfile())
                                   .company(argument.getCompany())
                                   .login(argument.getLogin())
                                   .staff(argument.getStaff())
                                   .build());
    }

    @Transactional
    public User update(@NonNull UUID id, @NonNull UpdateUserArgument argument) {
        User user = getExisting(id);

        user.setUsername(argument.getEmail());
        user.setLastLogin(LocalDateTime.now());
        user.setUpdateDate(LocalDateTime.now());

        return repository.save(user);
    }

    @Transactional
    public User setAvatarPath(@NonNull UUID id, @NonNull String avatarPath) {
        User user = getExisting(id);
        user.setAvatarPath(avatarPath);
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public User getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("User.notFound"));
    }

    @Transactional(readOnly = true)
    public Optional<User> getByLogin(@NonNull String login) {
        return repository.findByLogin(login);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        User existing = getExisting(id);
        existing.setEnabled(false);
        existing.setDeleted(true);
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
