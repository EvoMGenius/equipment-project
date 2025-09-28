package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.ModelBike;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Bike extends BaseEntity {

    /** Модель велосипеда */
    @ManyToOne(fetch = FetchType.EAGER)
    ModelBike modelBike;

    /** Порядковый номер внутри модели */
    @Column(nullable = false)
    Integer seqNumber;

    /** Инвентарный номер */
    @Column(nullable = false)
    Integer invNumber;

    /** VIN — уникальный идентификатор транспортного средства */
    @Column(nullable = false)
    String vin;

    /** Марка/модель моторного колеса */
    @Column(nullable = false)
    String motorWheel;

    /** Ссылка на SIM/IOT устройство, привязанное к этому Bike */
    @OneToOne(fetch = FetchType.EAGER)
    Iot iot;

    /** Статус велосипеда */
    @Column(nullable = false)
    BikeStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;
}
