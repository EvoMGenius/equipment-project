package org.apatrios.service.management.user;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.User;
import org.apatrios.repository.managment.UserRepository;
import org.apatrios.service.management.user.argument.CreateUserArgument;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
                                   .email(argument.getEmail())
                                   .avatar(argument.getAvatar())
                                   .userProfile(argument.getUserProfile())
                                   .createDate(LocalDateTime.now())
                                   .phoneNumber(argument.getPhoneNumber())
                                   .password(encoder.encode(argument.getPassword()))
                                   .build());
    }

    @Transactional
    public User update(@NonNull UUID id, @NonNull UpdateUserArgument argument) {
        User user = getExisting(id);

        Optional.ofNullable(argument.getUserProfile()).ifPresent(user::setUserProfile);
        Optional.ofNullable(argument.getPhoneNumber()).ifPresent(user::setPhoneNumber);
        Optional.ofNullable(argument.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(argument.getAvatar()).ifPresent(user::setAvatar);

        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public User getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("User.notFound"));
    }

    @Transactional(readOnly = true)
    public Optional<User> getByPhoneNumber(@NonNull String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
