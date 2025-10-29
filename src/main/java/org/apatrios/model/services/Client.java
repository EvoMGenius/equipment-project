package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
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
public class Client extends BaseEntity {

    /** Контактная информация */
    @Embedded
    ClientProfile clientProfile;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ClientStatus status;

    /** Компания */
    @ManyToOne(fetch = FetchType.LAZY)
    Franchisee franchisee;

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
