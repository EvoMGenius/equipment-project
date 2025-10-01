package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

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
public class Staff extends BaseEntity {

    /** Контактная информация сотрудника */
    @Embedded
    StaffProfile staffProfile;

    /** Должность сотрудника */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Position position;

    /** Франчайзинговая точка */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Franchisee franchisee;

    /** Статус сотрудника */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    StaffStatus status;

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
