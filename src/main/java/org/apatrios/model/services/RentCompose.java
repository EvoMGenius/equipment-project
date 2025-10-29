package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class RentCompose extends BaseEntity {

    /** Аренда */
    @ManyToOne(fetch = FetchType.LAZY)
    Rent rent;

    /** Кол-во объектов в аренде */
    @Column(nullable = false)
    Integer amount;

    /** ID велосипеда, экипировки или запчасти */
    @Column(nullable = false)
    UUID objectId;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;

    /** Идентификаторы франчайзи */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "rent_compose_franchisee")
    @Column(name = "franchisee_id")
    Set<UUID> franchiseeIds = new HashSet<>();
}
