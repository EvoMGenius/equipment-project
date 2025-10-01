package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

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

    /** Уникальное имя для входа в систему */
    @Column(nullable = false)
    String login;

    /** Роль */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    /** Сотрудник */
    @ManyToOne(fetch = FetchType.LAZY)
    Staff staff;

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
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;
}
