package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.services.Photo;

import javax.persistence.*;

import java.time.LocalDateTime;

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

    /** Адрес электронной почты */
    @Column(unique = true)
    String email;

    /** Номер телефона */
    String phoneNumber;

    /** Пароль */
    String password;

    /** Дата регистрации в системе */
    LocalDateTime createDate;

    /** Флаг подтверждения почты */
    @Builder.Default
    Boolean isEmailVerified = false;

    /** Флаг верификации документов */
    @Builder.Default
    Boolean isDocVerified = false;

    /*** Аватар пользователя */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_photo_id")
    Photo avatar;
}
