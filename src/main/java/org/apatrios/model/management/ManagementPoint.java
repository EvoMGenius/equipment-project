package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.PointType;

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
public class ManagementPoint extends BaseEntity {

    /** Название точки */
    @Column(nullable = false)
    String name;

    /** Физический адрес точки */
    @Column(nullable = false)
    String address;

    /** Франчайзи */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Franchisee franchisee;

    /** Тип точки */
    @ManyToOne(optional = false)
    PointType pointType;

    /** Тип точки */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PointStatus status;

    /** Географическая широта */
    @Column(nullable = false)
    Double latitude;

    /** Географическая долгота */
    @Column(nullable = false)
    Double longitude;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;
}
