package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Point extends BaseEntity {

    /** Тип точки */
    @Column(nullable = false)
    Dict pointType;

    /** Название точки */
    @Column(nullable = false)
    String name;

    /** Номер точки */
    @Column(nullable = false)
    String number;

    /** Физический адрес */
    @Column(nullable = false)
    String address;

    /** График работы */
    @Column(nullable = false)
    String workTime;

    /** Статус */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;
}
