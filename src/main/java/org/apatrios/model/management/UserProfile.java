package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UserProfile {
    /** Имя пользователя */
    @Column(nullable = false)
    String firstName;

    /** Фамилия пользователя */
    String lastName;

    /** Дата рождения */
    LocalDate dateOfBirth;
}
