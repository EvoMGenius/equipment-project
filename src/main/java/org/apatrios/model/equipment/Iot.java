package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.IotModel;
import org.apatrios.model.management.Company;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Iot extends BaseEntity {

    /** Модель IOT-модуля */
    @ManyToOne(fetch = FetchType.LAZY)
    IotModel iotModel;

    /** Инвентаризационный номер IOT-модуля */
    String invNumber;

    /** Франчайзи / Компания */
    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    /** IMEI мобильного оборудования */
    String imei;

    /** Ссылка на сим-карту */
    UUID simId;

    /** Текущий статус модуля */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    IotStatus status;

    /** Комментарий к запчасти / модулю */
    String comment;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    boolean isDeleted = false;
}