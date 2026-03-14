package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.services.Photo;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    /** Профиль */
    @Embedded
    UserProfile userProfile;

    /*** Аватар пользователя */
    @Embedded
    Photo avatar;

    /** Адрес электронной почты */
    @Column(unique = true)
    String email;

    /** Номер телефона */
    String phoneNumber;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    UserStatus status;

    /** Роли */
    @Column(name = "authority")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
    Set<String> authorities;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    Boolean isDeleted = false;

    /** Флаг подтверждения */
    @Builder.Default
    Boolean isVerified = false;

    /** Флаг подтверждения почты */
    @Builder.Default
    Boolean isEmailVerified = false;
}
