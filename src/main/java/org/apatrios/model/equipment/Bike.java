package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Company;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    /** Модель велосипеда — Внешний ключ. Справочник "Модели велосипедов" */
    @ManyToOne(fetch = FetchType.LAZY)
    ModelBike modelBike;

    /** ID франчайзи — Внешний ключ. Бизнес-объект "Франчайзи" */
    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    /** Порядковый номер велосипеда внутри модели */
    Integer seqNumber;

    /** Инвентаризационный номер велосипеда внутри велопарка */
    @Column(nullable = false)
    Integer invNumber;

    /** VIN электровелосипеда */
    String vin;

    /** № мотор-колеса */
    String motorWheel;

    /** IOT-модуль — Внешний ключ. Бизнес-объект "IOT-модули" */
    @ManyToOne(fetch = FetchType.LAZY)
    Iot iot;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    BikeStatus status;

    /** Комментарий к велосипеду */
    String comment;

    /** Дата и время создания записи в реестре */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи в реестре */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    Boolean isDeleted = false;
}