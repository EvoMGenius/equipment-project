package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "user_account")
public class User extends BaseEntity {

    /** Уникальное имя для входа в систему */
    @Column(nullable = false)
    String username;

    /** Пароль */
    @Column(nullable = false)
    String password;

    /** Роли */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authorities"})})
    Set<String> authorities;

    /** Сотрудник */
    @ManyToOne(fetch = FetchType.LAZY)
    Staff staff;

    /** Контактная информация пользователя */
    @Embedded
    UserProfile userProfile;

    /** Статус пользователя */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    UserStatus status;

    @Column(nullable = false)
    LocalDateTime lastLogin;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true")
    boolean enabled = true;
}
