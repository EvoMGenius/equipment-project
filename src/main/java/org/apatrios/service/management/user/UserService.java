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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository repository;

    @Transactional
    public User create(@NonNull CreateUserArgument argument) {
        return repository.save(User.builder()
                                   .email(argument.email())
                                   .avatar(argument.avatar())
                                   .userProfile(argument.userProfile())
                                   .phoneNumber(argument.phoneNumber())
                                   .authorities(argument.authorities())
                                   .isVerified(true)
                                   .status(UserStatus.PRE_REGISTERED)
                                   .build());
    }

    @Transactional
    public User update(@NonNull UUID id, @NonNull UpdateUserArgument argument) {
        User user = getExisting(id);

        Optional.ofNullable(argument.userProfile()).ifPresent(user::setUserProfile);
        Optional.ofNullable(argument.phoneNumber()).ifPresent(user::setPhoneNumber);
        Optional.ofNullable(argument.email()).ifPresent(user::setEmail);
        Optional.ofNullable(argument.avatar()).ifPresent(user::setAvatar);
        Optional.ofNullable(argument.status()).ifPresent(user::setStatus);
        Optional.ofNullable(argument.isEmailVerified()).ifPresent(user::setIsEmailVerified);
        Optional.ofNullable(argument.authorities()).ifPresent(user::setAuthorities);

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
