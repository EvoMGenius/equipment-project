package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

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
    String firstName;

    /** Фамилия пользователя */
    String lastName;

    /** Отчество */
    String patronymic;
}
