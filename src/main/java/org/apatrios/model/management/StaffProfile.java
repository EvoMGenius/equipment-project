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
public class StaffProfile {
    /** Номер телефона*/
    @Column(nullable = false)
    String phone;

    /** Фамилия */
    @Column(nullable = false)
    String surname;

    /** Имя */
    @Column(nullable = false)
    String name;

    /** Электронный адрес */
    @Column(nullable = false)
    String email;
}
