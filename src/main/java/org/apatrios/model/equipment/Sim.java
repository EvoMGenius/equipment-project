package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Operator;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Sim extends BaseEntity {

    /** Номер телефона */
    @Column(nullable = false)
    String phoneNumber;

    /** Справочник оператор */
    @ManyToOne(fetch = FetchType.LAZY)
    Operator operator;
}
