package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.PointType;
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
public class Point extends BaseEntity {

    /** Тип точки */
    @ManyToOne(fetch = FetchType.LAZY)
    PointType pointType;

    /** Название точки */
    @Column(nullable = false)
    String name;

    /** Физический адрес */
    @Column(nullable = false)
    String address;

    /** Внешний ключ: Бизнес-объект "Компания" */
    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    /** Географическая широта */
    Double latitude;

    /** Географическая долгота */
    Double longitude;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PointStatus status;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    Boolean isDeleted = false;
}
