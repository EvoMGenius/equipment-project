package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Franchisee;

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
public class Bike extends BaseEntity {

    /** Модель велосипеда */
    @ManyToOne(fetch = FetchType.LAZY)
    ModelBike modelBike;

    /** Франчайзи */
    @ManyToOne(fetch = FetchType.LAZY)
    Franchisee franchisee;

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
    @OneToOne(fetch = FetchType.LAZY)
    Iot iot;

    /** Статус велосипеда */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    BikeStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;
}
