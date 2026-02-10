package org.apatrios.model.management;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.UserRole;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
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
@TypeDef(name = "json", typeClass = JsonType.class)
public class User extends BaseEntity {

    /** Отображаемое имя */
    String username;

    /** Уникальное имя для входа в систему */
    @Column(nullable = false)
    String login;

    /** Пароль */
    String password;

    /** Аватарка */
    String avatarPath;

    /** Роли */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    Set<UserRole> roles = new HashSet<>();

    /** Информация пользователя */
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

    /** Доступен ли для входа аккаунт */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true")
    boolean enabled = true;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;

    /** Франчайзи */
    @ManyToOne(fetch = FetchType.LAZY)
    Franchisee company;

    /** Сотрудник */
    @ManyToOne(fetch = FetchType.LAZY)
    Staff staff;
}
