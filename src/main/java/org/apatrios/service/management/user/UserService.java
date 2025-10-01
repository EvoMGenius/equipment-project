package org.apatrios.service.management.user;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final QUser qUser = QUser.user;

    @Transactional
    public User create(@NonNull CreateUserArgument argument) {
        return repository.save(User.builder()
                                   .login(argument.getLogin())
                                   .role(argument.getRole())
                                   .staff(argument.getStaff())
                                   .status(UserStatus.ACTIVE)
                                   .createDate(LocalDateTime.now())
                                   .updateDate(LocalDateTime.now())
                                   .lastLogin(LocalDateTime.now())
                                   .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User update(@NonNull UUID id, @NonNull UpdateUserArgument argument) {
        User existing = getExisting(id);

        existing.setLogin(argument.getLogin());
        existing.setRole(argument.getRole());
        existing.setStaff(argument.getStaff());
        existing.setStatus(argument.getStatus());
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
                          .add(argument.getLogin(), qUser.login::containsIgnoreCase)
                          .add(argument.getLastLoginFrom(), qUser.lastLogin::goe)
                          .add(argument.getLastLoginTo(), qUser.lastLogin::loe)
                          .add(argument.getRole(), qUser.role::eq)
                          .add(argument.getStaffId(), qUser.staff.id::eq)
                          .add(argument.getStatus(), qUser.status::eq)
                          .add(argument.getCreateDateFrom(), qUser.createDate::goe)
                          .add(argument.getCreateDateTo(), qUser.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qUser.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qUser.updateDate::loe)
                          .add(argument.isDeleted(), qUser.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public User getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        User existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
