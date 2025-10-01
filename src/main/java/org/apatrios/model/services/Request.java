package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.ServiceType;

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
public class Request extends BaseEntity {

    /** Контактная информация */
    @Embedded
    RequestProfile requestProfile;

    /** Тип услуги */
    @ManyToOne
    ServiceType serviceType;

    /** Модель велосипеда */
    @ManyToOne
    ModelBike modelBike;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String note;

    /** Клиент */
    @ManyToOne(fetch = FetchType.LAZY)
    Client client;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RequestStatus status;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    @Column(nullable = false)
    LocalDateTime updateDate;

    /** Признак удаления */
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;
}