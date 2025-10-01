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
public class FranchiseeProfile {
    /** Номер телефона*/
    @Column(nullable = false)
    String phone;

    /** Имя */
    @Column(nullable = false)
    String name;

    /** Электронный адрес */
    @Column(nullable = false)
    String email;

    /** Физический адрес франчайзи */
    @Column(nullable = false)
    String address;
}
