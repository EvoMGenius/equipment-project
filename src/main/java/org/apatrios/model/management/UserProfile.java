package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
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

    /** Фамилия */
    @Column(nullable = false)
    String lastName;

    /** Имя */
    @Column(nullable = false)
    String firstName;

    /** Отчество */
    @Column(nullable = false)
    String middleName;
}
